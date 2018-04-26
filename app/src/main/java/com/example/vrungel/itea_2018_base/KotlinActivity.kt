package com.example.vrungel.itea_2018_base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log

class KotlinActivity : AppCompatActivity() {
  companion object {
    fun function1() {}
  }

  val str: String? = "string"
  val a:Int = 0

  val array = arrayListOf("1", "2", "3", "qwe", "sae", "sdae1")


  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_kotlin)
    Log.wtf("KotlinActivity", str)
    str?.let {
      Log.wtf("KotlinActivity", "${it} not null")
    }
    MyObject.newObjFun()

    when (str) {
      "1" -> {
      }
      "2" -> {
      }
      else -> {
      }
    }

    with(array) {
      add("222")
      add("222")
      add("222")

    }

    printList(array.asSequence()
        .filter { it.contains("e") }
        .filter { it.contains("1") }
        .toList())
  }

  fun printList(list: List<String>, type: Int = 1) {

    list.forEach {
      Log.wtf("KotlinActivity", it)
    }
  }
}
