package ru.voidcyborg.jttag.parser;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.voidcyborg.jttag.Utils;
import ru.voidcyborg.jttag.tag.DataType;
import ru.voidcyborg.jttag.tag.Tag;
import ru.voidcyborg.jttag.tag.TagFactory;
import ru.voidcyborg.jttag.tag.TransferTag;
import ru.voidcyborg.jttag.tags.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.fail;

class TagFactoryTest {

    @Test
    void transferTag() {
        TransferTag tag = new TransferTag();
        tag.putString("lol", "data");
        tag.putString("g312", "fafafaf");
        tag.putString("43666", "da34444ta");


        TransferTag tagInside = tag.putTag("tag");
        tagInside.putString("name", "bebra");
        tagInside.putString("hi", "lol");


        TransferTag boltest = tag.putTag("boolTest");
        boltest.putBoolean("test1", true);
        boltest.putBoolean("test2", false);
        boltest.putIntArray("intArray", new int[]{4214, 555, 11, 33, 777});
        boltest.putIntArray("intArray null", null);
        boltest.putByteArray("byteArray", new byte[]{44, 31, 127, -128});
        boltest.putByteArray("byteArray null", null);
        boltest.putBooleanArray("bolArray", null);
        boltest.putBooleanArray("bolArray2", new boolean[]{true, false, false});


        TransferTag shortTest = tag.putTag("ShortTest");
        shortTest.putShort("short", (short) 5215);
        shortTest.putShortArray("array", null);
        shortTest.putShortArray("name", new short[]{2414, 666, 22220});
        shortTest.putShortArray("empty", new short[0]);

        TransferTag tag2 = shortTest.putTag("tag2");
        tag2.putFloat("float", 421412.32541f);
        tag2.putFloat("ffff", -421412.566666f);
        tag2.putShortArray("short2", new short[]{2155, 666, 1111});

        TransferTag tag3 = tag2.putTag("tag3");
        tag3.putFloatArray("array", new float[]{-42141.55f, 115215.5512f, 0.00001f});
        tag3.putFloatArray("empty", new float[0]);
        tag3.putFloatArray("null", null);
        tag3.putDouble("double", 2142142198412.312314444444444);
        tag3.putDoubleArray("double_array", new double[]{2142142198412.312314444444444, 421481184.4214144, 1616215421.421414141});
        tag3.putDoubleArray("double_empty", new double[0]);
        tag3.putDoubleArray("double_null", null);
        tag3.putChar("char", '\n');
        tag3.putChar("char2", '@');

        TransferTag charTest = tag.putTag("charTest");
        charTest.putCharArray("charArray", new char[]{444, 0, 321, -0, 21355});
        charTest.putChar("char", (char) 68);


        byte[] bytes = tag.toBytes();

        TransferTag reconstructed = TagFactory.transferTag(bytes);

        Assertions.assertEquals(tag,reconstructed);
    }

    @Test
    void arrayTag() {

        //TODO TAG_ARRAY
        List<Tag> tags = new ArrayList<>();

        TransferTag tag1 = new TransferTag();
        tag1.putString("string", "datalol");
        tag1.putBoolean("boolean", true);
        tag1.putString("nullString", null);


        tags.add(new TransferTagArrayNode(new TransferTag[]{tag1, null}));
        tags.add(new TransferTagArrayNode(null));

        tags.add(new BooleanArrayNode(new boolean[]{true, false, true}));
        tags.add(new BooleanArrayNode(null));

        tags.add(new ByteArrayNode(new byte[]{5, 122, -56}));
        tags.add(new ByteArrayNode(null));

        tags.add(new ShortArrayNode(new short[]{312, 525, -566}));
        tags.add(new ShortArrayNode(null));

        tags.add(new IntegerArrayNode(new int[]{3142, 52115, -56666}));
        tags.add(new IntegerArrayNode(null));

        tags.add(new LongArrayNode(new long[]{314244, 5211225, -5644666}));
        tags.add(new LongArrayNode(null));

        tags.add(new FloatArrayNode(new float[]{314244.55f, 5211225.55f, -5644666.55f}));
        tags.add(new FloatArrayNode(null));

        tags.add(new DoubleArrayNode(new double[]{314244.55f, 521122455.55f, -56444666.55f}));
        tags.add(new DoubleArrayNode(null));

        tags.add(new CharacterArrayNode(new char[]{'2', '@', '!'}));
        tags.add(new CharacterArrayNode(null));

        tags.add(new StringArrayNode(new String[]{"agjkag", "fafafa", null}));
        tags.add(new StringArrayNode(null));

        try {

            byte[] bytes;
            byte[] data;
            byte[] sizeBytes = new byte[Integer.BYTES];
            int size;
            DataType type;

            for (Tag expected : tags) {
                bytes = expected.toBytes();
                type = DataType.getType(bytes[0]);
                if (!type.isArray()) fail("Data type should be array!");
                System.arraycopy(bytes, 1, sizeBytes, 0, Integer.BYTES);
                size = Utils.bytesToInt(sizeBytes);
                data = null;
                if (size >= 0) {
                    data = new byte[size];
                    System.arraycopy(bytes, 5, data, 0, data.length);
                }

                Tag actual = TagFactory.arrayTag(type, size, data);

                Assertions.assertEquals(expected, actual);
            }
        } catch (Exception e) {
            e.printStackTrace();
            fail("Catch exception");
        }


    }

    @Test
    void primitiveTag() {
    }

    @Test
    void stringTag() {
        List<StringNode> nodes = new ArrayList<>();
        nodes.add(new StringNode("gjalkga"));
        nodes.add(new StringNode("5215415"));
        nodes.add(new StringNode("77773"));
        nodes.add(new StringNode("1522151"));
        nodes.add(new StringNode(null));

        try {


            byte[] bytes;
            byte[] data;
            byte[] sizeBytes = new byte[Integer.BYTES];
            int size;
            DataType type;
            StringNode actual;

            for (Tag expected : nodes) {
                bytes = expected.toBytes();
                type = DataType.getType(bytes[0]);
                if (type != DataType.STRING) fail("Data type should be STRING!");

                System.arraycopy(bytes, 1, sizeBytes, 0, Integer.BYTES);
                size = Utils.bytesToInt(sizeBytes);
                data = null;

                if (size >= 0) {
                    data = new byte[size];
                    System.arraycopy(bytes, 5, data, 0, data.length);
                }

                actual = TagFactory.stringTag(size, data);

                Assertions.assertEquals(expected, actual);
            }
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }
}