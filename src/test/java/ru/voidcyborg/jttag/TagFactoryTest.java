package ru.voidcyborg.jttag;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.voidcyborg.jttag.tag.DataType;
import ru.voidcyborg.jttag.tag.Tag;
import ru.voidcyborg.jttag.tags.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.fail;

class TagFactoryTest {


    @Test
    void toJson(){
        TransferTag tag = new TransferTag();
        tag.putString("4444", "555555");
        tag.putString("bsdbsb", "2412141");
        TransferTag tag2 = tag.putTag("Test-Tag");

        tag2.putByteArray("43666", new byte[]{1,2,-2,55});
        tag2.putBooleanArray("boolean", new boolean[]{ true,false,true,false,false});
        tag.putCharArray("chars",new char[]{22,55,0,22});
        tag.putDoubleArray("doubles",new double[]{214.2,-312.21,-4212.2,444.65});
        tag.putFloatArray("floats",new float[]{-421.2f,5214f,215f,555f});
        tag2.putIntArray("ints",new int[]{42141,512521,-213414});
        tag.putShortArray("shorts",new short[]{1525,222,-244,222});
        tag2.putString("g312", "fafafaf");
        tag2.putString("43666", "da34444ta");
        tag2.putString("45566", "da3422444ta");
        tag2.putString("777777", "da34gff4444ta");
        System.out.println(tag.toJson(0));
    }

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

        Assertions.assertEquals(tag, reconstructed);
    }

    @Test
    void arrayTag() {

        Method method;
        try {
            method = TagFactory.class.getDeclaredMethod("arrayTag", DataType.class, int.class, byte[].class);
            method.setAccessible(true);
        } catch (Exception e) {
            fail("Failed create method");
            return;
        }


        List<Tag> tags = new ArrayList<>();

        TransferTag tag1 = new TransferTag();
        tag1.putString("string", "datalol");
        tag1.putBoolean("boolean", true);
        tag1.putString("nullString", null);

        try {
            Constructor<TransferTagArrayNode> constructor = TransferTagArrayNode.class.getDeclaredConstructor(TransferTag[].class);
            constructor.setAccessible(true);

            tags.add(constructor.newInstance((Object) new TransferTag[]{tag1, null}));
            tags.add(constructor.newInstance((Object) null));

            Constructor<BooleanArrayNode> constructor2 = BooleanArrayNode.class.getDeclaredConstructor(boolean[].class);
            constructor2.setAccessible(true);

            tags.add(constructor2.newInstance((Object) new boolean[]{true, false, true}));
            tags.add(constructor2.newInstance((Object) null));

            Constructor<ByteArrayNode> constructor3 = ByteArrayNode.class.getDeclaredConstructor(byte[].class);
            constructor3.setAccessible(true);

            tags.add(constructor3.newInstance((Object) new byte[]{5, 122, -56}));
            tags.add(constructor3.newInstance((Object) null));

            Constructor<ShortArrayNode> constructor4 = ShortArrayNode.class.getDeclaredConstructor(short[].class);
            constructor4.setAccessible(true);

            tags.add(constructor4.newInstance((Object) new short[]{312, 525, -566}));
            tags.add(constructor4.newInstance((Object) null));

            Constructor<IntegerArrayNode> constructor5 = IntegerArrayNode.class.getDeclaredConstructor(int[].class);
            constructor5.setAccessible(true);

            tags.add(constructor5.newInstance((Object) new int[]{3142, 52115, -56666}));
            tags.add(constructor5.newInstance((Object) null));

            Constructor<LongArrayNode> constructor6 = LongArrayNode.class.getDeclaredConstructor(long[].class);
            constructor6.setAccessible(true);

            tags.add(constructor6.newInstance((Object) new long[]{314244, 5211225, -5644666}));
            tags.add(constructor6.newInstance((Object) null));

            Constructor<FloatArrayNode> constructor7 = FloatArrayNode.class.getDeclaredConstructor(float[].class);
            constructor7.setAccessible(true);

            tags.add(constructor7.newInstance((Object) new float[]{314244.55f, 5211225.55f, -5644666.55f}));
            tags.add(constructor7.newInstance((Object) null));

            Constructor<DoubleArrayNode> constructor8 = DoubleArrayNode.class.getDeclaredConstructor(double[].class);
            constructor8.setAccessible(true);

            tags.add(constructor8.newInstance((Object) new double[]{314244.55f, 521122455.55f, -56444666.55f}));
            tags.add(constructor8.newInstance((Object) null));

            Constructor<CharacterArrayNode> constructor9 = CharacterArrayNode.class.getDeclaredConstructor(char[].class);
            constructor9.setAccessible(true);

            tags.add(constructor9.newInstance((Object) new char[]{'2', '@', '!'}));
            tags.add(constructor9.newInstance((Object) null));

            Constructor<StringArrayNode> constructor10 = StringArrayNode.class.getDeclaredConstructor(String[].class);
            constructor10.setAccessible(true);

            tags.add(constructor10.newInstance((Object) new String[]{"agjkag", "fafafa", null}));
            tags.add(constructor10.newInstance((Object) null));

        } catch (Exception e) {
            fail("Failed create constructor!");
        }

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

                Object object = method.invoke(null, type, size, data);

                if (object instanceof Tag actual) {
                    Assertions.assertEquals(expected, actual);
                } else {
                    fail("Can't recreate tag");
                }
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


        Method method;
        try {
            method = TagFactory.class.getDeclaredMethod("stringTag", int.class, byte[].class);
            method.setAccessible(true);
        } catch (Exception e) {
            fail("Failed create method");
            return;
        }

        List<StringNode> nodes = new ArrayList<>();
        Constructor<StringNode> constructor;

        try {
            constructor = StringNode.class.getDeclaredConstructor(String.class);
            constructor.setAccessible(true);


            nodes.add(constructor.newInstance("gjalkga"));
            nodes.add(constructor.newInstance("5215415"));
            nodes.add(constructor.newInstance("77773"));
            nodes.add(constructor.newInstance("1522151"));
            nodes.add(constructor.newInstance((Object) null));

        } catch (Exception e) {
            e.printStackTrace();
            fail("Failed create constructor");
            return;
        }

        try {


            byte[] bytes;
            byte[] data;
            byte[] sizeBytes = new byte[Integer.BYTES];
            int size;
            DataType type;

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

                Object object = method.invoke(null, size, data);


                if (object instanceof StringNode actual) {
                    Assertions.assertEquals(expected, actual);
                } else {
                    fail("Can't recreate tag");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }
}