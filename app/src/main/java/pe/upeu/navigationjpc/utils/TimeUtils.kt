package pe.upeu.navigationjpc.utils

import java.util.Calendar

fun isNight():Boolean{ //verificar si es de día o de noche
    val hora=
        Calendar.getInstance().get(Calendar.HOUR_OF_DAY)
    return (hora<=6 || hora>=18)
}