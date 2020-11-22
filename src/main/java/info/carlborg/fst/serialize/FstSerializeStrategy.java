package info.carlborg.fst.serialize;

import java.io.IOException;
import java.io.Serializable;

import org.nustaq.serialization.FSTConfiguration;

import info.carlborg.serializer.serialize.SerializeStrategy;

/**
 * Serialize Java objects using the superior
 * <a href="https://github.com/RuedigerMoeller/fast-serialization">fast-serialization (FST)
 * library</a>.
 * 
 * Refer to the SerializeStrategy interface for more details.
 */
public class FstSerializeStrategy implements SerializeStrategy {
  @Override
  public Serializable deserialize(final byte[] bytes) throws IOException {
    try {
      return (Serializable) fst.asObject(bytes);
    } catch (Exception e) {
      throw new IOException(e);
    }
  }

  @Override
  public byte[] serialize(final Serializable object) throws IOException {
    try {
      return fst.asByteArray(object);
    } catch (Exception e) {
      throw new IOException(e);
    }
  }
  
  private static final FSTConfiguration fst;
  static {
    fst = FSTConfiguration.createDefaultConfiguration();
  }
}
