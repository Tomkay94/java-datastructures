import static org.junit.Assert.*;
import org.junit.*;

public class AdjacencyMatrixTest {

  AdjacencyMatrix adjMat;

  @Before
  public void setUp() {
    adjMat  = new AdjacencyMatrix(5);
  }

  @After
  public void tearDown() {
    adjMat  = null;
  }

  @Test
  public void testAdjMatrixConstructor() {
    assertNotNull(adjMat);
  }
}
