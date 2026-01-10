package com.example

import org.jetbrains.exposed.sql.Table

// class - şablon görevi görür
// Singleton prensibi
object Oyunlar : Table("oyunlar")
{
    val id = integer("id").autoIncrement()
    val ad = varchar("ad", 50)
    val tur = varchar("tur", 50)
    val resimDosya = varchar("resim_dosya", 100).nullable()
    override val primaryKey = PrimaryKey(id)
}

object Yapimcilar : Table("yapimcilar")
{
    val id = integer("id").autoIncrement()
    val firmaAdi = varchar("firma_adi", 50)
    override val primaryKey = PrimaryKey(id)
}

object OyunYapimci : Table("oyunyapimci")
{
    val oyunId = reference("oyun_id", Oyunlar.id)
    val yapimciId = reference("yapimci_id", Yapimcilar.id)
    override val primaryKey = PrimaryKey(oyunId,yapimciId)
}


