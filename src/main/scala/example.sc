"Hello World!!"

def and(x:Boolean, y:Boolean) = if(x) y else false

and(true, true)
and(true, false)
and(false, true)
and(false, false)

def or(x:Boolean, y: => Boolean) = if(x) true else y
or(true, true)
or(true, false)
or(false, true)
or(false, false)