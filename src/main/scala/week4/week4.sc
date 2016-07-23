import week4.Huffman
import week4.Huffman.{Fork, Leaf}

val msg = Huffman.decodedSecret
val code = Huffman.encode(Huffman.frenchCode)(msg)
code == Huffman.secret

List(0,0,1,1,1,0,1,0,1,1,1,0,0,1,1,0,1,0,0,1,1,0,1,0,1,1,0,0,1,1,1,1,1,0,1,0,1,1,0,0,0,0,1,0,1,1,1,0,0,1,0,0,1,0,0,0,1,0,0,0,1,0,1)




