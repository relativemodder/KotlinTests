import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min
import kotlin.math.sqrt
import kotlin.math.pow

class Vertice{
    var x:Float
    var y:Float

    constructor(x_:Float, y_:Float){
        x = x_
        y = y_
    }
}
class Triangle{

    var vertice1:Vertice
    var vertice2:Vertice
    var vertice3:Vertice

    constructor(x1:Float, y1:Float, x2:Float, y2:Float, x3:Float, y3:Float) {
        vertice1 = Vertice(x1, y1)
        vertice2 = Vertice(x2, y2)
        vertice3 = Vertice(x3, y3)
    }

    val a: Float
        get() {
            return sqrt((vertice2.x - vertice1.x).pow(2) + (vertice2.y - vertice1.y).pow(2))
        }
    val b: Float
        get() {
            return sqrt((vertice3.x - vertice2.x).pow(2) + (vertice3.y - vertice2.y).pow(2))
        }
    val c: Float
        get() {
            return sqrt((vertice3.x - vertice1.x).pow(2) + (vertice3.y - vertice1.y).pow(2))
        }
    val perimeter: Float
        get() {
            return findPerimeter()
        }
    val square: Float
        get() {
            return findSquare()
        }
    val medianCrossingPoint: Vertice
        get() {
            return findMedianCrossingPoint()
        }
    fun findSquare(): Float{
        val p = perimeter / 2
        return sqrt(p * (p - a) * (p - b) * (p - c))
    }
    fun findPerimeter(): Float{
        return a + b + c
    }
    fun findMedianCrossingPoint(): Vertice{
        return Vertice(
            (vertice1.x + vertice2.x + vertice3.x) / 3.0f,
            (vertice1.x + vertice2.x + vertice3.x) / 3.0f
        )
    }
    fun findCenter(): Vertice{
        val minx = min(vertice1.x, min(vertice2.x, vertice3.x))
        val miny = min(vertice1.y, min(vertice2.y, vertice3.y))
        val maxx = max(vertice1.x, max(vertice2.x, vertice3.x))
        val maxy = max(vertice1.y, max(vertice2.y, vertice3.y))

        return Vertice((minx + maxx) / 2, (miny + maxy) / 2)
    }
}
fun inputWithPrompt(prompt: String): String{
    print(prompt)
    return readln()
}
fun main(args: Array<String>) {
    println("Введите вершины треугольника: ")

    val x1 = inputWithPrompt("x1: ").toFloat()
    val y1 = inputWithPrompt("y1: ").toFloat()

    val x2 = inputWithPrompt("x2: ").toFloat()
    val y2 = inputWithPrompt("y2: ").toFloat()

    val x3 = inputWithPrompt("x3: ").toFloat()
    val y3 = inputWithPrompt("y3: ").toFloat()

    val triangle: Triangle = Triangle(x1, y1, x2, y2, x3, y3)



    print("Периметр: ${triangle.perimeter}")
    print("Площадь: ${triangle.square}")
    print("Точка пересечения медиан: (${triangle.medianCrossingPoint.x}; ${triangle.medianCrossingPoint.y})")
}