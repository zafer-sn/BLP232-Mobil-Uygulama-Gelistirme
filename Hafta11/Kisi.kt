package com.example.firestoreuygulama
/*
* Kisi data classı ile constructor(yapıcı metot) kullanarak
* isim, soyisim ve yas degerlerini istiyoruz. Eğer değerler
* gönderilmezse varsayılan olarak isim için boş değer(""),
* soyisim için yine boş değer("") ve yas içinde (-1) değerini atıyoruz.
* Kisi data classından bir nesne oluşturulduğunda isim, soyisim ve yas
* değerlerinin verilmesi gerektiğini belirttik(varsayılan değerler
* olduğu için zorunlu değil)
* */
data class Kisi(
    var isim: String = "",
    var soyisim: String = "",
    var yas: Int = -1
)
