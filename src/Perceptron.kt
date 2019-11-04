import java.util.*
import kotlin.random.Random

class Perceptron(private val input_training:Array<Array<Double>>,private val output_training:Array<Double>) {
    private val learning_rate=0.2
    private val wInput=Array(3,{Array<Double>(3,{0.0})})
    private val wOut=Array<Double>(3,{0.0})
    private val output1=Array<Double>(3,{0.0})
    private var output2:Double
    private var error:Double
    init {
        output2=0.0
        error=0.0
        var r =Random(Date().time)
        wInput.indices.forEach{
            wOut[it]=r.nextDouble()*2-1
            wInput[it]= arrayOf(r.nextDouble()*2-1,r.nextDouble()*2-1,r.nextDouble()*2-1)
        }

    }
    fun predict(k:Array<Double>):Double{
        output1.indices.forEach {
            output1[it]=0.0
        }
        output2=0.0
        wInput.indices.forEach{i->
            wInput[i].indices.forEach{
                output1[i]+=k[it]*wInput[it][i]
            }
            output1[i]=sigmoid(output1[i])
        }
        output1.indices.forEach {
            output2+=output1[it]*wOut[it]
        }
        return sigmoid(output2)

    }
    fun train(){
        for (p in 0..50000){
            input_training.indices.forEach { l->
                output2=predict(input_training[l])
                error=output2-output_training[l]
                val weight_delta=error*sigmoidDerivative(error)
                wOut.indices.forEach{
                    wOut[it]-=learning_rate*weight_delta*output1[it]
                }
                wInput.indices.forEach{i->
                    wInput[i].indices.forEach{
                        val er=wOut[it]*weight_delta
                        wInput[i][it]-=input_training[l][i]*learning_rate*er*sigmoidDerivative(er)
                    }
                }
            }
        }
    }

    private fun sigmoid(x: Double): Double {
        return 1.0 / (1.0 + Math.pow(Math.E, -1.0 * x))
    }
    private fun sigmoidDerivative(x: Double):Double {
        return sigmoid(x)*(1.0 - sigmoid(x))
    }
}