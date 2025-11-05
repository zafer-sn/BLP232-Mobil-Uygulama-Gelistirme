package com.example.hafta5.oop

interface Insan
{
    fun Solunum()
    fun Dolasim()
    var boy: Double
    var isim: String
    var kilo: Double
}

class Erkek : Insan
{
    override fun Solunum() {

    }

    override fun Dolasim() {
    }

    override var kilo: Double
        get() = TODO("Not yet implemented")
        set(value) {}
    override var boy: Double
        get() = TODO("Not yet implemented")
        set(value) {}
    override var isim: String
        get() = TODO("Not yet implemented")
        set(value) {}
}

class Kadin : Insan
{
    override fun Solunum() {
        TODO("Not yet implemented")
    }

    override fun Dolasim() {
        TODO("Not yet implemented")
    }

    override var boy: Double
        get() = TODO("Not yet implemented")
        set(value) {}
    override var isim: String
        get() = TODO("Not yet implemented")
        set(value) {}
    override var kilo: Double
        get() = TODO("Not yet implemented")
        set(value) {}

}