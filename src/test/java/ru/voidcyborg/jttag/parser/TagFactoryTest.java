package ru.voidcyborg.jttag.parser;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.voidcyborg.jttag.Utils;
import ru.voidcyborg.jttag.tag.DataType;
import ru.voidcyborg.jttag.tag.Tag;
import ru.voidcyborg.jttag.tags.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.fail;

class TagFactoryTest {

    @Test
    void transferTag() {
    }

    @Test
    void arrayTag() {

        //TODO TAG_ARRAY
        List<Tag> tags = new ArrayList<>();

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