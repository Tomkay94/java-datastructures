import static org.junit.Assert.*;
import org.junit.*;

public class GraphTest {

  GraphAdjacencyMatrix adjMat;
  GraphAdjacencyList adjList;

  @Before
  public void setUp() {
    adjMat  = new GraphAdjacencyMatrix(5);
    adjList = new GraphAdjacencyList<String>();
  }

  @After
  public void tearDown() {
    adjMat  = null;
    adjList = null;
  }

  @Test
  public void testAdjMatrixConstructor() {
    assertNotNull(adjMat);
  }

  @Test
  public void testAdjListConstructor() {
    assertNotNull(adjList);
  }
}
