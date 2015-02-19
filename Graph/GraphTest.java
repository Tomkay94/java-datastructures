import static org.junit.Assert.*;
import org.junit.*;

public class GraphTest {

  GraphAdjacencyMatrix adjMat;

  @Before
  public void setUp() {
    adjMat = new GraphAdjacencyMatrix(5);
  }

  @After
  public void tearDown() {
    adjMat = null;
  }

  @Test
  public void testAdjMatrixInit() {
    assertNotNull(adjMat);
  }
}
