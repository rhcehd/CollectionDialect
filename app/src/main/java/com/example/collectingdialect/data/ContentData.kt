package com.example.collectingdialect.data

import android.content.Context
import com.example.collectingdialect.R
import org.apache.poi.hssf.usermodel.HSSFWorkbook
import org.apache.poi.xssf.usermodel.XSSFFactory
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import org.xml.sax.helpers.NamespaceSupport

object ContentData {
    val dialectScriptArray = arrayOf(
        "할마이한테 어제 내린 누리 때문에 메물밭이 엉망이 되었으니 얼른 일어나라고 문자 보내 주소.",
        "저녁에 먹을 약이 마카 떨어진 모냉이니 내일 예약 가능한 근처 병원 알아봐 주소.",
        "글패에 사우가 오랜만에 손주들을 데리고 온다니까 국시 삶고 모갱이 약 치게 내일 다섯 시에 알람 맞춰 줘소.",
        "엿술은 옥씨끼를 갈어서 그 엿을 고아 가주구 질금을 빼먹지 않고 넣어야 먈갛다고 메모해 줘수.",
        "옆집 동상이 셋바눌이 나서 아무것도 못 먹고 있으니 성한테 오는 길에 해마듬 먹던 약을 사오라고 문자 보내 줘수.",
        "진갈비 내리기 전에 도옹네 사람들이랑 미리 도화 정리하게 이번 주 날씨 마카 알려 줘소.",
        "젯노리/제누리 먹고 나서 자우름 안 오게 듣기 좋은 잔재 노래 틀어줘소.",
        "으찌냑에 벅아궁이에 몰래 숨어 있던 고냉이랑 여깽이 새끼 밥 줄 시간 예약해 줘수.",
        "낼모레 막냉이가 마구간 모랭이에 있는 버덩에서 마뎅이 하기로 한 시간이 언제였는지 확인해 줘소.",
        "새벅 시장에 오늘 건추랑 물외 나오는 날인지 일정 확인해 줘소."
    )

    val standardScriptArray = arrayOf(
        "할머니한테 어제 내린 우박 때문에 메밀밭이 엉망이 되었으니 얼른 일어나라고 문자 보내 줘.",
        "저녁에 먹을 약이 전부 떨어진 모양이니 내일 예약 가능한 근처 병원 알아봐 줘.",
        "글피에 사위가 오랜만에 손주들을 데리고 온다니까 국수 삶고 모기 약 치게 내일 다섯 시에 알람 맞춰 줘.",
        "엿술은 옥수수를 갈아서 그 엿을 고아 가지고 엿기름을 빼먹지 않고 넣어야 말갛다고 메모해 줘.",
        "옆집 아우가 혓바늘이 나서 아무것도 못 먹고 있으니 형한테 오는 길에 해마다 먹던 약을 사오라고 문자 보내 줘.",
        "진눈개비 내리기 전에 마을 사람들이랑 미리 마당앞/집주변 정리하게 이번 주 날씨 전부 알려 줘.",
        "새참 먹고 나서 졸음 안 오게 듣기 좋은 잔치 노래 틀어줘.",
        "어제 저녁에 아궁이에 몰래 숨어 있던 고양이랑 여우 새끼 밥 줄 시간 예약해줘.",
        "모레 막내아들이 외양간 모퉁이에 있는 들판에서 타작 하기로 한 시간이 언제였는지 확인해 줘.",
        "새벽 시장에 오늘 시래기랑 오이 나오는 날인지 일정 확인해 줘."
    )

    val imageArray = arrayOf(
        R.drawable.sample1,
        R.drawable.sample2,
        R.drawable.sample3,
        R.drawable.sample4,
        R.drawable.sample5,
        R.drawable.sample6,
        R.drawable.sample7,
        R.drawable.sample8,
    )

    fun init(context: Context) {
        val inputStream = context.resources.openRawResource(R.raw.repeat_gangwon_set_1)
        val list = arrayListOf<String>()
        try {
            val workBook = XSSFWorkbook(inputStream)
            val sheet = workBook.getSheetAt(0)
            sheet.forEach { row ->
                list.add(row.getCell(2).stringCellValue)
            }
            "hello"
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }
}