package com.bignerdranch.nyethack

import java.util.*

interface Fightable {
    var healthPoints : Int // 건강 점수
    val diceCount: Int // 주사위 개수
    val diceSides: Int // 주사위 면
    val damageRoll: Int // 주사위 굴려서 나온 숫자 총합_적에게 입힐 데미지
        get() = (0 until diceCount).map {
            Random().nextInt(diceSides) + 1
        }.sum()

    fun attack(opponent: Fightable): Int
}

abstract class Monster(val name: String,
                       val description: String,
                       override var healthPoints: Int) : Fightable {
    override fun attack(opponent: Fightable): Int {
        val damageDealt = damageRoll
        opponent.healthPoints -= damageDealt
        return damageDealt
    }
}

class Goblin(name: String = "Goblin",
             description: String = "추하게 생긴 고블린",
             healthPoints: Int = 30) : Monster(name, description,healthPoints) {

    override val diceCount = 2
    override val diceSides = 8
}