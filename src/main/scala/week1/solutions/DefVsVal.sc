// The difference between val and def becomes apparent when the right hand side does not terminate.

def loop: Int = loop

def x: Int = loop

val x1: Int = loop // will lead to an infinite loop.
