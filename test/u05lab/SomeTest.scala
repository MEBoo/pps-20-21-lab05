package u05lab.code

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions._

class SomeTest {

  @Test
  def testZipRight() {
    val l = List("a", "b", "c")

    assertEquals(List.nil, List.nil.zipRight)
    assertEquals(List(("a", 0), ("b", 1), ("c", 2)), l.zipRight)
  }
  @Test
  def testPartition(){
    val l=List(1,2,3,4,5,6,7)
    assertEquals((List(1,2,3),List(4,5,6,7)),l.partition(_<4))
    assertEquals((List(1,2,3),List(4,5,6,7)),l.partitionSlow(_<4))
  }
  @Test
  def testSpan(){
    val l = 10 :: 20 :: 30 :: 40 :: Nil()
    assertEquals(( Nil(), Cons(10,Cons(20,Cons(30,Cons(40,Nil())))) ),l.span(_>15))
    assertEquals(( Cons(10,Nil()), Cons(20,Cons(30,Cons(40,Nil()))) ),l.span(_<15))
    assertEquals(( Cons(10,Cons(20,Nil())), Cons(30,Cons(40,Nil())) ),l.span(_<25))
    assertEquals(( Cons(10,Cons(20,Cons(30,Cons(40,Nil())))), Nil() ),l.span(_<50))

  }

  @Test
  def testReduce(){
    val l = 10 :: 20 :: 30 :: 40 :: Nil()
    
    assertEquals(100,l.reduce(_+_))
    assertEquals(10,List(10).reduce(_+_))
    assertThrows(classOf[UnsupportedOperationException], ()=>List.nil[Int].reduce(_+_))
  }

  @Test
  def testTakeRight(){
    val l = 10 :: 20 :: 30 :: 40 :: Nil()

    assertEquals(Cons(30,Cons(40,Nil())),l.takeRight(2))
  }

  @Test
  def testCollect(){
    val l = 10 :: 20 :: 30 :: 40 :: Nil()

    assertEquals(Cons(9, Cons(39, Nil())),l.collect { case x if x<15 || x>35 => x-1 })
  }
}