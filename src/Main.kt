fun main() {
    val input_training=arrayOf(arrayOf(0.0,0.0,1.0),arrayOf(1.0,1.0,1.0),arrayOf(1.0,0.0,1.0),arrayOf(0.0,1.0,1.0))
    val output_training= arrayOf(0.0,1.0,1.0,0.0)
    var a=Perceptron(input_training,output_training)
    a.train()
    val input= arrayOf(arrayOf(1.0,0.0,0.0),arrayOf(0.0,0.0,0.0),arrayOf(1.0,1.0,0.0),arrayOf(0.0,0.0,1.0),arrayOf(1.0,1.0,1.0),arrayOf(1.0,0.0,1.0),arrayOf(0.0,1.0,1.0))
    val output= arrayOf(1.0,0.0,1.0,0.0,1.0,1.0,0.0)
    input.indices.forEach {
        println("Wait: ${output[it]}"+" Expect: " +a.predict(input[it]).toString())
    }


}

