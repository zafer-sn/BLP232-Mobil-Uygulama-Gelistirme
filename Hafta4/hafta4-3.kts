interface IApp
{
    var id: Int
    var status: String
    fun Request()
    fun Token()
}
interface IGet {
    var maxLength: Int
    fun JWT()
}
class istekAt : IApp, IGet
{
    override var id: Int = 5
    override var status: String
        get() = TODO("Not yet implemented")
        set(value) {}

    override fun Request() {
        TODO("Not yet implemented")
    }

    override fun Token() {
        TODO("Not yet implemented")
    }

    override var maxLength: Int
        get() = TODO("Not yet implemented")
        set(value) {}

    override fun JWT() {
        TODO("Not yet implemented")
    }

}