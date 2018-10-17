package ru.yusdm.kubetraining.memoryleak

class MemoryLeakApplication

val list = mutableListOf<String>()

fun main(args: Array<String>) {

    var counter = 0
    while (true) {
        list.add("Test str to call memory leak! ")
        if (counter++ % 5000000 == 0) {
            println("Memory leak in progress. Size of list with strings is '${list.size}'")
        }
    }

}
