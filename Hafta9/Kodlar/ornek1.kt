@Composable
fun ana_sayfa()
{
    var renk by remember { mutableStateOf(Color.Red) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(renk),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = {
                var kirmizi = Random.nextInt(0, 255)
                var yesil = Random.nextInt(0, 255)
                var mavi = Random.nextInt(0, 255)
                renk = Color(red =  kirmizi, green=yesil, blue = mavi)
            }
        ) {
            Text(
                text = "Mavi Yap",
                fontSize = 36.sp
            )
        }
    }
}