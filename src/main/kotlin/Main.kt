fun main(args: Array<String>) {
    val num = 2;
    println(num.pow(3))
    num.pow(3) {x:Int -> println(x)}
    3.displayTypeInfo()
    "a".displayTypeInfo()
    true.displayTypeInfo()
    DataType.DoubleType(1.4).displayDataTypeInfo()
    DataType.UnitType.displayDataTypeInfo()
}

fun Int.pow(exp:Int):Int{
    if(exp == 0) return 1;
    return this * this.pow(exp-1)
}

fun Int.pow(exp:Int, f: (r:Int) -> Unit){
    f(this.pow(exp))
}

fun Any.displayTypeInfo(){
    when(this){
        is String -> println("это String")
        is Int -> println("это Int")
        else -> println("тип у $this неизвестен")
    }
}

fun DataType.displayDataTypeInfo(){
    when(this){
        is DataType.DoubleType -> println("это DoubleType co значеним ${(this as DataType.DoubleType).value}")
        is DataType.UnitType -> println("это Unit")
    }
}

sealed class DataType {
    class DoubleType(val value:Double): DataType()
    object UnitType : DataType()
}