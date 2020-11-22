package info.carlborg.fst.serialize;

import org.junit.jupiter.api.BeforeAll;
import info.carlborg.serializer.ObjectSerializer;
import info.carlborg.serializer.compress.PassthroughCompressStrategy;
import info.carlborg.serializer.encode.Base64EncodeStrategy;
import info.carlborg.serializer.encrypt.PassthroughEncryptStrategy;

/**
 * See ObjectSerializerTest for test cases.
 */
public class FstTest extends ObjectSerializerTest {
  @BeforeAll
  static void initPassthroughSerializer() {
    serializer = new ObjectSerializer(new FstSerializeStrategy(), new PassthroughCompressStrategy(),
        new PassthroughEncryptStrategy(), new Base64EncodeStrategy());
  }
}
