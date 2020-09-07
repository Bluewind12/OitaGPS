package momonyan.oitagps.function_list

import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

fun getNowDate(): String {
    val df: DateFormat = SimpleDateFormat("yyyy/MM/dd HH:mm:ss")
    val date = Date(System.currentTimeMillis())
    val nowDate = df.format(date)
    if(nowDate == ""){
        return "エラー"
    }
    return nowDate
}