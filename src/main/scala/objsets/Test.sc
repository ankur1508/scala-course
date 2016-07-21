import objsets.{Empty, Tweet, TweetSet}

val set1 = Empty
val set2 = set1.incl(new Tweet("a", "a body", 20))
set2.foreach(println)

val set3 = set2.incl(new Tweet("b", "b body", 20))
set3.foreach(println)

val c = new Tweet("c", "this is android", 7)
val d = new Tweet("d", "d body", 9)

val set4c = set3.incl(c)
val set4d = set3.incl(d)
val set5 = set4c.incl(d)

set5.foreach(println)

set5.filter(tw => tw.user == "a").foreach(println)

set5.mostRetweeted

val ascList = set5.descendingByRetweet
ascList.foreach(println)
def reverse(list: TweetList, newList : TweetList) : TweetList = {
  if(list isEmpty)
    newList
  else
    reverse(list.tail, new Cons(list.head, newList))
}
reverse(ascList, Nil).foreach(println)


val google = List("android", "Android", "galaxy", "Galaxy", "nexus", "Nexus")
val apple = List("ios", "iOS", "iphone", "iPhone", "ipad", "iPad")


def find(tweet: Tweet, ref: List[String]): Boolean = {
    ref.exists(tweet.text contains _)
}
find(c, google)