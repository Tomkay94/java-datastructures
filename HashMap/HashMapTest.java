import static org.junit.Assert.*;
import org.junit.*;

public class HashMapTest {

  /* Common test case hash map capacity. */
  private static final int TEST_CAPACITY = 7;

  /* Threshold for float comparison accuracy. */
  private static final double DELTA = 1e-15;
  HashMap hm;

  @Before
  public void setUp() {
    hm = new HashMap(TEST_CAPACITY);
  }

  @After
  public void tearDown() {
    hm = null;
  }

  @Test
  public void testHashMapConstructor() {
    assertEquals(hm.getCapacity(), TEST_CAPACITY);
    assertEquals(hm.getSize(), 0);
    assertEquals(hm.load(), (float) 0, DELTA);
  }

  @Test
  public void testMapCapacity_BecomesPrime_WhenInputEven() {
    HashMap mapEvenCapacity = new HashMap(4);

    assertEquals(mapEvenCapacity.getCapacity(), 5); 
  }

  @Test
  public void testMapCapacity_BecomesPrime_WhenInputOdd() {
    HashMap mapOddCapacity = new HashMap(15);

    assertEquals(mapOddCapacity.getCapacity(), 17);
  }

  @Test
  public void testMapCapacity_RemainsPrime_WhenInputPrime() {
    HashMap mapPrimeCapacity = new HashMap(TEST_CAPACITY);

    assertEquals(mapPrimeCapacity.getCapacity(), TEST_CAPACITY);
  }

  @Test
  public void testInsert_SingleKey() {  
    boolean wasInserted = hm.set("Toronto", 10);
    assertTrue(wasInserted);

    assertEquals(hm.get("Toronto"), Integer.valueOf(10));
  }

  @Test
  public void testInsert_MaxIntValue() {
    boolean wasInserted = hm.set("Toronto", Integer.MAX_VALUE);
    assertTrue(wasInserted);

    assertEquals(hm.get("Toronto"), Integer.valueOf(Integer.MAX_VALUE));
  }

  @Test
  public void testInsert_DuplicatesOverwrite() {
    boolean wasInserted     = hm.set("New York", 15);
    assertTrue(wasInserted);

    boolean wasInsertedAlso = hm.set("New York", 10);
    assertTrue(wasInsertedAlso);

    assertEquals(hm.get("New York"), Integer.valueOf(10));
  }

  @Test
  public void testGetKey_FindsKey() {
    hm.set("Toronto", 10);

    assertEquals(hm.get("Toronto"), Integer.valueOf(10));
  }

  @Test
  public void testGet_InvalidKey() {

    assertNull(hm.get("Copenhagen"));
  }

  @Test
  public void testDelete_RemovesEntry() {
    hm.set("Toronto", 10);
    hm.delete("Toronto");

    assertNull(hm.get("Toronto"));
  }

  @Test
  public void testDelete_ExistingEntry() {
    hm.set("Toronto", 10);
    boolean wasDeleted = hm.delete("Toronto");

    assertTrue(wasDeleted);
  }

  @Test
  public void testDelete_NonExistingEntry() {
    boolean wasDeleted = hm.delete("Toronto");

    assertFalse(wasDeleted);
  }

  @Test
  public void testDelete_DecreasesSize() {
    assertEquals(hm.getSize(), 0);
    
    hm.set("New York", 10);
    hm.set("San Francisco", 10);
    hm.set("Palo Alto", 10);
    assertEquals(hm.getSize(), 3);

    hm.delete("Palo Alto");
    assertEquals(hm.getSize(), 2);

    hm.delete("New York");
    assertEquals(hm.getSize(), 1);

    hm.delete("San Francisco");
    assertEquals(hm.getSize(), 0);

  }

  @Test
  public void testInsert_IncreasesSize() {
    assertEquals(hm.getSize(), 0);
    
    hm.set("Toronto", 10);
    assertEquals(hm.getSize(), 1);
    
    hm.set("New York", 10);
    assertEquals(hm.getSize(), 2);

    hm.set("San Francisco", 10);
    assertEquals(hm.getSize(), 3);

    hm.set("Palo Alto", 10);    
    assertEquals(hm.getSize(), 4);
  }

  @Test
  public void testInsert_IncreasesLoad() {
    assertEquals(hm.getSize(), 0);
    
    /* Continuously perform inserts, and check 
      that the load has increased with each insert. */
    
    float previousLoad = hm.load();
    hm.set("Toronto", 10);
    assertTrue(hm.load() > previousLoad);
    
    previousLoad = hm.load();
    hm.set("New York", 10);
    assertTrue(hm.load() > previousLoad);
  
    previousLoad = hm.load();
    hm.set("San Francisco", 10);
    assertTrue(hm.load() > previousLoad);
  
    previousLoad = hm.load();
    hm.set("Palo Alto", 10);    
    assertTrue(hm.load() > previousLoad);
  }

  @Test
  public void testDelete_DecreasesLoad() {
    assertEquals(hm.getSize(), 0);

    hm.set("Palo Alto", 10);    
    hm.set("Toronto", 10);
    hm.set("New York", 10);
    hm.set("San Francisco", 10);
    
    /* Continuously perform deletes, and check 
      that the load has increased with each delete. */
    
    float previousLoad = hm.load();
    hm.delete("Toronto");
    assertTrue(hm.load() < previousLoad);
    
    previousLoad = hm.load();
    hm.delete("New York");
    assertTrue(hm.load() < previousLoad);
  
    previousLoad = hm.load();
    hm.delete("San Francisco");
    assertTrue(hm.load() < previousLoad);
  
    previousLoad = hm.load();
    hm.delete("Palo Alto");
    assertTrue(hm.load() < previousLoad);
  }
}
