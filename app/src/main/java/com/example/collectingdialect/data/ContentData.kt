package com.example.collectingdialect.data

import android.content.Context
import com.example.collectingdialect.R
import com.example.collectingdialect.ui.content.region.RegionSelectionViewModel
import java.io.InputStream
import java.io.InputStreamReader

object ContentData {
    /*val dialectScriptArray = arrayOf(
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
    )*/

    private const val TAB_STRING = "    "

    private var repeatScriptTextGangwonSet1Dialect = arrayOf<String>()
    private var repeatScriptTextGangwonSet2Dialect = arrayOf<String>()
    private var repeatScriptTextGangwonSet3Dialect = arrayOf<String>()
    private var repeatScriptTextChungcheongSet1Dialect = arrayOf<String>()
    private var repeatScriptTextChungcheongSet2Dialect = arrayOf<String>()
    private var repeatScriptTextChungcheongSet3Dialect = arrayOf<String>()
    private var repeatScriptTextGyeongsangSet1Dialect = arrayOf<String>()
    private var repeatScriptTextGyeongsangSet2Dialect = arrayOf<String>()
    private var repeatScriptTextGyeongsangSet3Dialect = arrayOf<String>()
    private var repeatScriptTextJeonraSet1Dialect = arrayOf<String>()
    private var repeatScriptTextJeonraSet2Dialect = arrayOf<String>()
    private var repeatScriptTextJeonraSet3Dialect = arrayOf<String>()
    private var repeatScriptTextJejuSet1Dialect = arrayOf<String>()
    private var repeatScriptTextJejuSet2Dialect = arrayOf<String>()
    private var repeatScriptTextJejuSet3Dialect = arrayOf<String>()

    private var repeatScriptTextGangwonSet1Standard = arrayOf<String>()
    private var repeatScriptTextGangwonSet2Standard = arrayOf<String>()
    private var repeatScriptTextGangwonSet3Standard = arrayOf<String>()
    private var repeatScriptTextChungcheongSet1Standard = arrayOf<String>()
    private var repeatScriptTextChungcheongSet2Standard = arrayOf<String>()
    private var repeatScriptTextChungcheongSet3Standard = arrayOf<String>()
    private var repeatScriptTextGyeongsangSet1Standard = arrayOf<String>()
    private var repeatScriptTextGyeongsangSet2Standard = arrayOf<String>()
    private var repeatScriptTextGyeongsangSet3Standard = arrayOf<String>()
    private var repeatScriptTextJeonraSet1Standard = arrayOf<String>()
    private var repeatScriptTextJeonraSet2Standard = arrayOf<String>()
    private var repeatScriptTextJeonraSet3Standard = arrayOf<String>()
    private var repeatScriptTextJejuSet1Standard = arrayOf<String>()
    private var repeatScriptTextJejuSet2Standard = arrayOf<String>()
    private var repeatScriptTextJejuSet3Standard = arrayOf<String>()

    private val repeatScriptVoiceGangwonSet1 = arrayOf(
        R.raw.gw_1_001, R.raw.gw_1_002, R.raw.gw_1_003, R.raw.gw_1_004, R.raw.gw_1_005, R.raw.gw_1_006, R.raw.gw_1_007, R.raw.gw_1_008, R.raw.gw_1_009, R.raw.gw_1_010, R.raw.gw_1_011, R.raw.gw_1_012, R.raw.gw_1_013, R.raw.gw_1_014, R.raw.gw_1_015, R.raw.gw_1_016, R.raw.gw_1_017, R.raw.gw_1_018, R.raw.gw_1_019, R.raw.gw_1_020, R.raw.gw_1_021, R.raw.gw_1_022, R.raw.gw_1_023, R.raw.gw_1_024, R.raw.gw_1_025, R.raw.gw_1_026, R.raw.gw_1_027, R.raw.gw_1_028, R.raw.gw_1_029, R.raw.gw_1_030, R.raw.gw_1_031, R.raw.gw_1_032, R.raw.gw_1_033, R.raw.gw_1_034, R.raw.gw_1_035, R.raw.gw_1_036, R.raw.gw_1_037, R.raw.gw_1_038, R.raw.gw_1_039, R.raw.gw_1_040, R.raw.gw_1_041, R.raw.gw_1_042, R.raw.gw_1_043, R.raw.gw_1_044, R.raw.gw_1_045, R.raw.gw_1_046, R.raw.gw_1_047, R.raw.gw_1_048, R.raw.gw_1_049, R.raw.gw_1_050, R.raw.gw_1_051, R.raw.gw_1_052, R.raw.gw_1_053, R.raw.gw_1_054, R.raw.gw_1_055, R.raw.gw_1_056, R.raw.gw_1_057, R.raw.gw_1_058, R.raw.gw_1_059, R.raw.gw_1_060, R.raw.gw_1_061, R.raw.gw_1_062, R.raw.gw_1_063, R.raw.gw_1_064, R.raw.gw_1_065, R.raw.gw_1_066, R.raw.gw_1_067, R.raw.gw_1_068, R.raw.gw_1_069, R.raw.gw_1_070, R.raw.gw_1_071, R.raw.gw_1_072, R.raw.gw_1_073, R.raw.gw_1_074, R.raw.gw_1_075, R.raw.gw_1_076, R.raw.gw_1_077, R.raw.gw_1_078, R.raw.gw_1_079, R.raw.gw_1_080, R.raw.gw_1_081, R.raw.gw_1_082, R.raw.gw_1_083, R.raw.gw_1_084, R.raw.gw_1_085, R.raw.gw_1_086, R.raw.gw_1_087, R.raw.gw_1_088, R.raw.gw_1_089, R.raw.gw_1_090, R.raw.gw_1_091, R.raw.gw_1_092, R.raw.gw_1_093, R.raw.gw_1_094, R.raw.gw_1_095, R.raw.gw_1_096, R.raw.gw_1_097, R.raw.gw_1_098, R.raw.gw_1_099, R.raw.gw_1_100, R.raw.gw_1_101, R.raw.gw_1_102, R.raw.gw_1_103, R.raw.gw_1_104, R.raw.gw_1_105, R.raw.gw_1_106, R.raw.gw_1_107, R.raw.gw_1_108, R.raw.gw_1_109
    )
    private var repeatScriptVoiceGangwonSet2 = arrayOf<Int>()
    private var repeatScriptVoiceGangwonSet3 = arrayOf<Int>()
    private var repeatScriptVoiceChungcheongSet1 = arrayOf(
        R.raw.cc_1_001, R.raw.cc_1_002, R.raw.cc_1_003, R.raw.cc_1_004, R.raw.cc_1_005, R.raw.cc_1_006, R.raw.cc_1_007, R.raw.cc_1_008, R.raw.cc_1_009, R.raw.cc_1_011, R.raw.cc_1_012, R.raw.cc_1_013, R.raw.cc_1_015, R.raw.cc_1_016, R.raw.cc_1_017, R.raw.cc_1_018, R.raw.cc_1_019, R.raw.cc_1_020, R.raw.cc_1_021, R.raw.cc_1_022, R.raw.cc_1_023, R.raw.cc_1_024, R.raw.cc_1_025, R.raw.cc_1_026, R.raw.cc_1_027, R.raw.cc_1_028, R.raw.cc_1_029, R.raw.cc_1_030, R.raw.cc_1_031, R.raw.cc_1_032, R.raw.cc_1_033, R.raw.cc_1_034, R.raw.cc_1_035, R.raw.cc_1_036, R.raw.cc_1_037, R.raw.cc_1_038, R.raw.cc_1_039, R.raw.cc_1_040, R.raw.cc_1_041, R.raw.cc_1_042, R.raw.cc_1_043, R.raw.cc_1_044, R.raw.cc_1_045, R.raw.cc_1_046, R.raw.cc_1_048, R.raw.cc_1_049, R.raw.cc_1_051, R.raw.cc_1_052, R.raw.cc_1_053, R.raw.cc_1_054, R.raw.cc_1_055, R.raw.cc_1_056, R.raw.cc_1_057, R.raw.cc_1_058, R.raw.cc_1_060, R.raw.cc_1_061, R.raw.cc_1_062, R.raw.cc_1_063, R.raw.cc_1_064, R.raw.cc_1_065, R.raw.cc_1_066, R.raw.cc_1_067, R.raw.cc_1_070, R.raw.cc_1_071, R.raw.cc_1_072, R.raw.cc_1_074, R.raw.cc_1_075, R.raw.cc_1_076, R.raw.cc_1_077, R.raw.cc_1_078, R.raw.cc_1_079, R.raw.cc_1_081, R.raw.cc_1_082, R.raw.cc_1_084, R.raw.cc_1_085, R.raw.cc_1_086, R.raw.cc_1_087, R.raw.cc_1_089, R.raw.cc_1_091, R.raw.cc_1_092, R.raw.cc_1_093, R.raw.cc_1_095, R.raw.cc_1_096, R.raw.cc_1_098, R.raw.cc_1_099, R.raw.cc_1_100, R.raw.cc_1_102, R.raw.cc_1_103, R.raw.cc_1_106, R.raw.cc_1_108, R.raw.cc_1_109, R.raw.cc_1_110
    )
    private var repeatScriptVoiceChungcheongSet2 = arrayOf<Int>()
    private var repeatScriptVoiceChungcheongSet3 = arrayOf<Int>()
    private var repeatScriptVoiceGyeongsangSet1 = arrayOf(
        R.raw.gs_1_004, R.raw.gs_1_005, R.raw.gs_1_006, R.raw.gs_1_007, R.raw.gs_1_008, R.raw.gs_1_009, R.raw.gs_1_010, R.raw.gs_1_011, R.raw.gs_1_012, R.raw.gs_1_013, R.raw.gs_1_014, R.raw.gs_1_015, R.raw.gs_1_016, R.raw.gs_1_017, R.raw.gs_1_018, R.raw.gs_1_019, R.raw.gs_1_020, R.raw.gs_1_021, R.raw.gs_1_022, R.raw.gs_1_023, R.raw.gs_1_024, R.raw.gs_1_025, R.raw.gs_1_026, R.raw.gs_1_027, R.raw.gs_1_028, R.raw.gs_1_029, R.raw.gs_1_030, R.raw.gs_1_031, R.raw.gs_1_032, R.raw.gs_1_033, R.raw.gs_1_034, R.raw.gs_1_035, R.raw.gs_1_036, R.raw.gs_1_037, R.raw.gs_1_038, R.raw.gs_1_039, R.raw.gs_1_040, R.raw.gs_1_041, R.raw.gs_1_042, R.raw.gs_1_043, R.raw.gs_1_044, R.raw.gs_1_045, R.raw.gs_1_046, R.raw.gs_1_047, R.raw.gs_1_048, R.raw.gs_1_049, R.raw.gs_1_050, R.raw.gs_1_051, R.raw.gs_1_052, R.raw.gs_1_053, R.raw.gs_1_054, R.raw.gs_1_055, R.raw.gs_1_056, R.raw.gs_1_057, R.raw.gs_1_058, R.raw.gs_1_059, R.raw.gs_1_060, R.raw.gs_1_061, R.raw.gs_1_062, R.raw.gs_1_063, R.raw.gs_1_064, R.raw.gs_1_065, R.raw.gs_1_066, R.raw.gs_1_067, R.raw.gs_1_068, R.raw.gs_1_069, R.raw.gs_1_070, R.raw.gs_1_071, R.raw.gs_1_072, R.raw.gs_1_073, R.raw.gs_1_074, R.raw.gs_1_075, R.raw.gs_1_076, R.raw.gs_1_077, R.raw.gs_1_078, R.raw.gs_1_079, R.raw.gs_1_080, R.raw.gs_1_081, R.raw.gs_1_082, R.raw.gs_1_083, R.raw.gs_1_084, R.raw.gs_1_085, R.raw.gs_1_086, R.raw.gs_1_087, R.raw.gs_1_088, R.raw.gs_1_089, R.raw.gs_1_090, R.raw.gs_1_091, R.raw.gs_1_092, R.raw.gs_1_093, R.raw.gs_1_094, R.raw.gs_1_095, R.raw.gs_1_096, R.raw.gs_1_097, R.raw.gs_1_098, R.raw.gs_1_099, R.raw.gs_1_100, R.raw.gs_1_101, R.raw.gs_1_102, R.raw.gs_1_103, R.raw.gs_1_104, R.raw.gs_1_105, R.raw.gs_1_106, R.raw.gs_1_107, R.raw.gs_1_108, R.raw.gs_1_109, R.raw.gs_1_110
    )
    private var repeatScriptVoiceGyeongsangSet2 = arrayOf<Int>()
    private var repeatScriptVoiceGyeongsangSet3 = arrayOf<Int>()
    private var repeatScriptVoiceJeonraSet1 = arrayOf<Int>(
        R.raw.jr_1_001, R.raw.jr_1_002, R.raw.jr_1_003, R.raw.jr_1_004, R.raw.jr_1_005, R.raw.jr_1_006, R.raw.jr_1_007, R.raw.jr_1_008, R.raw.jr_1_009, R.raw.jr_1_010, R.raw.jr_1_011, R.raw.jr_1_012, R.raw.jr_1_013, R.raw.jr_1_014, R.raw.jr_1_015, R.raw.jr_1_016, R.raw.jr_1_017, R.raw.jr_1_018, R.raw.jr_1_019, R.raw.jr_1_020, R.raw.jr_1_021, R.raw.jr_1_022, R.raw.jr_1_023, R.raw.jr_1_024, R.raw.jr_1_025, R.raw.jr_1_026, R.raw.jr_1_027, R.raw.jr_1_028, R.raw.jr_1_029, R.raw.jr_1_030, R.raw.jr_1_031, R.raw.jr_1_032, R.raw.jr_1_033, R.raw.jr_1_034, R.raw.jr_1_035, R.raw.jr_1_036, R.raw.jr_1_037, R.raw.jr_1_038, R.raw.jr_1_039, R.raw.jr_1_040, R.raw.jr_1_041, R.raw.jr_1_042, R.raw.jr_1_043, R.raw.jr_1_044, R.raw.jr_1_045, R.raw.jr_1_046, R.raw.jr_1_047, R.raw.jr_1_048, R.raw.jr_1_049, R.raw.jr_1_050, R.raw.jr_1_051, R.raw.jr_1_052, R.raw.jr_1_053, R.raw.jr_1_054, R.raw.jr_1_055, R.raw.jr_1_056, R.raw.jr_1_057, R.raw.jr_1_058, R.raw.jr_1_059, R.raw.jr_1_060, R.raw.jr_1_061, R.raw.jr_1_062, R.raw.jr_1_063, R.raw.jr_1_064, R.raw.jr_1_065, R.raw.jr_1_066, R.raw.jr_1_067, R.raw.jr_1_068, R.raw.jr_1_069, R.raw.jr_1_070, R.raw.jr_1_071, R.raw.jr_1_072, R.raw.jr_1_073, R.raw.jr_1_074, R.raw.jr_1_075, R.raw.jr_1_076, R.raw.jr_1_077, R.raw.jr_1_078, R.raw.jr_1_079, R.raw.jr_1_080, R.raw.jr_1_081, R.raw.jr_1_082, R.raw.jr_1_083, R.raw.jr_1_084, R.raw.jr_1_085, R.raw.jr_1_086, R.raw.jr_1_087, R.raw.jr_1_088, R.raw.jr_1_089, R.raw.jr_1_090, R.raw.jr_1_091, R.raw.jr_1_092, R.raw.jr_1_093, R.raw.jr_1_094, R.raw.jr_1_095, R.raw.jr_1_096, R.raw.jr_1_097, R.raw.jr_1_098, R.raw.jr_1_099, R.raw.jr_1_100, R.raw.jr_1_101, R.raw.jr_1_102, R.raw.jr_1_103, R.raw.jr_1_104, R.raw.jr_1_105, R.raw.jr_1_106, R.raw.jr_1_107, R.raw.jr_1_108, R.raw.jr_1_109, R.raw.jr_1_110, R.raw.jr_1_111, R.raw.jr_1_112, R.raw.jr_1_113, R.raw.jr_1_114, R.raw.jr_1_115, R.raw.jr_1_116, R.raw.jr_1_117, R.raw.jr_1_118, R.raw.jr_1_119
    )
    private var repeatScriptVoiceJeonraSet2 = arrayOf<Int>()
    private var repeatScriptVoiceJeonraSet3 = arrayOf<Int>()
    private var repeatScriptVoiceJejuSet1 = arrayOf<Int>(
        R.raw.jj_1_001, R.raw.jj_1_002, R.raw.jj_1_003, R.raw.jj_1_004, R.raw.jj_1_005, R.raw.jj_1_006, R.raw.jj_1_007, R.raw.jj_1_008, R.raw.jj_1_009, R.raw.jj_1_010, R.raw.jj_1_011, R.raw.jj_1_012, R.raw.jj_1_013, R.raw.jj_1_014, R.raw.jj_1_015, R.raw.jj_1_016, R.raw.jj_1_017, R.raw.jj_1_018, R.raw.jj_1_019, R.raw.jj_1_020, R.raw.jj_1_021, R.raw.jj_1_022, R.raw.jj_1_023, R.raw.jj_1_024, R.raw.jj_1_025, R.raw.jj_1_026, R.raw.jj_1_027, R.raw.jj_1_028, R.raw.jj_1_029, R.raw.jj_1_030, R.raw.jj_1_031, R.raw.jj_1_032, R.raw.jj_1_033, R.raw.jj_1_034, R.raw.jj_1_035, R.raw.jj_1_036, R.raw.jj_1_037, R.raw.jj_1_038, R.raw.jj_1_039, R.raw.jj_1_040, R.raw.jj_1_041, R.raw.jj_1_042, R.raw.jj_1_043, R.raw.jj_1_044, R.raw.jj_1_045, R.raw.jj_1_046, R.raw.jj_1_047, R.raw.jj_1_048, R.raw.jj_1_049, R.raw.jj_1_050, R.raw.jj_1_051, R.raw.jj_1_052, R.raw.jj_1_053, R.raw.jj_1_054, R.raw.jj_1_055, R.raw.jj_1_056, R.raw.jj_1_057, R.raw.jj_1_058, R.raw.jj_1_059, R.raw.jj_1_060, R.raw.jj_1_061, R.raw.jj_1_062, R.raw.jj_1_063, R.raw.jj_1_064, R.raw.jj_1_065, R.raw.jj_1_066, R.raw.jj_1_067, R.raw.jj_1_068, R.raw.jj_1_069, R.raw.jj_1_070, R.raw.jj_1_071, R.raw.jj_1_072, R.raw.jj_1_073, R.raw.jj_1_074, R.raw.jj_1_075, R.raw.jj_1_076, R.raw.jj_1_077, R.raw.jj_1_078, R.raw.jj_1_079, R.raw.jj_1_080, R.raw.jj_1_081, R.raw.jj_1_082, R.raw.jj_1_083, R.raw.jj_1_084, R.raw.jj_1_085, R.raw.jj_1_086, R.raw.jj_1_087, R.raw.jj_1_088, R.raw.jj_1_089, R.raw.jj_1_090, R.raw.jj_1_091, R.raw.jj_1_092, R.raw.jj_1_093, R.raw.jj_1_094, R.raw.jj_1_095, R.raw.jj_1_096, R.raw.jj_1_097, R.raw.jj_1_098, R.raw.jj_1_099, R.raw.jj_1_100, R.raw.jj_1_101, R.raw.jj_1_102, R.raw.jj_1_103, R.raw.jj_1_104, R.raw.jj_1_105, R.raw.jj_1_106, R.raw.jj_1_107, R.raw.jj_1_108, R.raw.jj_1_109
    )
    private var repeatScriptVoiceJejuSet2 = arrayOf<Int>()
    private var repeatScriptVoiceJejuSet3 = arrayOf<Int>()


    private var qnaScriptTextGangwonSet1 = arrayOf<String>()
    private var qnaScriptTextGangwonSet2 = arrayOf<String>()
    private var qnaScriptTextGangwonSet3 = arrayOf<String>()
    private var qnaScriptTextChungCheongSet1 = arrayOf<String>()
    private var qnaScriptTextChungCheongSet2 = arrayOf<String>()
    private var qnaScriptTextChungCheongSet3 = arrayOf<String>()
    private var qnaScriptTextGyeongsangSet1 = arrayOf<String>()
    private var qnaScriptTextGyeongsangSet2 = arrayOf<String>()
    private var qnaScriptTextGyeongsangSet3 = arrayOf<String>()
    private var qnaScriptTextJeonraSet1 = arrayOf<String>()
    private var qnaScriptTextJeonraSet2 = arrayOf<String>()
    private var qnaScriptTextJeonraSet3 = arrayOf<String>()
    private var qnaScriptTextJejuSet1 = arrayOf<String>()
    private var qnaScriptTextJejuSet2 = arrayOf<String>()
    private var qnaScriptTextJejuSet3 = arrayOf<String>()


    private var conversationScriptTextGangwonSet1 = arrayOf<String>()
    private var conversationScriptTextGangwonSet2 = arrayOf<String>()
    private var conversationScriptTextGangwonSet3 = arrayOf<String>()
    private var conversationScriptTextChungCheongSet1 = arrayOf<String>()
    private var conversationScriptTextChungCheongSet2 = arrayOf<String>()
    private var conversationScriptTextChungCheongSet3 = arrayOf<String>()
    private var conversationScriptTextGyeongsangSet1 = arrayOf<String>()
    private var conversationScriptTextGyeongsangSet2 = arrayOf<String>()
    private var conversationScriptTextGyeongsangSet3 = arrayOf<String>()
    private var conversationScriptTextJeonraSet1 = arrayOf<String>()
    private var conversationScriptTextJeonraSet2 = arrayOf<String>()
    private var conversationScriptTextJeonraSet3 = arrayOf<String>()
    private var conversationScriptTextJejuSet1 = arrayOf<String>()
    private var conversationScriptTextJejuSet2 = arrayOf<String>()
    private var conversationScriptTextJejuSet3 = arrayOf<String>()

    private val conversationImage = arrayOf(
        R.drawable.conversation_image_1, R.drawable.conversation_image_2, R.drawable.conversation_image_3, R.drawable.conversation_image_4, R.drawable.conversation_image_5, R.drawable.conversation_image_6, R.drawable.conversation_image_7, R.drawable.conversation_image_8, R.drawable.conversation_image_9, R.drawable.conversation_image_10, R.drawable.conversation_image_11, R.drawable.conversation_image_12, R.drawable.conversation_image_13, R.drawable.conversation_image_14, R.drawable.conversation_image_15, R.drawable.conversation_image_16, R.drawable.conversation_image_17, R.drawable.conversation_image_18, R.drawable.conversation_image_19, R.drawable.conversation_image_20, R.drawable.conversation_image_21, R.drawable.conversation_image_22, R.drawable.conversation_image_23, R.drawable.conversation_image_24
    )

    fun init(context: Context) {
        var rawData: InputStream
        var inputStreamReader: InputStreamReader

        // Initialize Repeat text part start
        try {
            rawData = context.resources.openRawResource(R.raw.repeat_gangwon_1)
            inputStreamReader = InputStreamReader(rawData)
            val dialectArrayList = arrayListOf<String>()
            val standardArrayList = arrayListOf<String>()
            inputStreamReader.forEachLine {
                val temp = it.split(TAB_STRING)
                if(temp.size != 2) {
                    return@forEachLine
                }
                dialectArrayList.add(temp[0])
                standardArrayList.add(temp[1])
            }
            repeatScriptTextGangwonSet1Dialect = dialectArrayList.toTypedArray()
            repeatScriptTextGangwonSet1Standard = standardArrayList.toTypedArray()
        } catch (e: Exception) {
            e.printStackTrace()
        }

        try {
            rawData = context.resources.openRawResource(R.raw.repeat_chungcheong_1)
            inputStreamReader = InputStreamReader(rawData)
            val dialectArrayList = arrayListOf<String>()
            val standardArrayList = arrayListOf<String>()
            inputStreamReader.forEachLine {
                val temp = it.split(TAB_STRING)
                if(temp.size != 2) {
                    return@forEachLine
                }
                dialectArrayList.add(temp[0])
                standardArrayList.add(temp[1])
            }
            repeatScriptTextChungcheongSet1Dialect = dialectArrayList.toTypedArray()
            repeatScriptTextChungcheongSet1Standard = standardArrayList.toTypedArray()
        } catch (e: Exception) {
            e.printStackTrace()
        }

        try {
            rawData = context.resources.openRawResource(R.raw.repeat_gyeongsang_1)
            inputStreamReader = InputStreamReader(rawData)
            val dialectArrayList = arrayListOf<String>()
            val standardArrayList = arrayListOf<String>()
            inputStreamReader.forEachLine {
                val temp = it.split(TAB_STRING)
                if(temp.size != 2) {
                    return@forEachLine
                }
                dialectArrayList.add(temp[0])
                standardArrayList.add(temp[1])
            }
            repeatScriptTextGyeongsangSet1Dialect = dialectArrayList.toTypedArray()
            repeatScriptTextGyeongsangSet1Standard = standardArrayList.toTypedArray()
        } catch (e: Exception) {
            e.printStackTrace()
        }

        try {
            rawData = context.resources.openRawResource(R.raw.repeat_jeonra_1)
            inputStreamReader = InputStreamReader(rawData)
            val dialectArrayList = arrayListOf<String>()
            val standardArrayList = arrayListOf<String>()
            inputStreamReader.forEachLine {
                val temp = it.split(TAB_STRING)
                if(temp.size != 2) {
                    return@forEachLine
                }
                dialectArrayList.add(temp[0])
                standardArrayList.add(temp[1])
            }
            repeatScriptTextJeonraSet1Dialect = dialectArrayList.toTypedArray()
            repeatScriptTextJeonraSet1Standard = standardArrayList.toTypedArray()
        } catch (e: Exception) {
            e.printStackTrace()
        }

        try {
            rawData = context.resources.openRawResource(R.raw.repeat_jeju_1)
            inputStreamReader = InputStreamReader(rawData)
            val dialectArrayList = arrayListOf<String>()
            val standardArrayList = arrayListOf<String>()
            inputStreamReader.forEachLine {
                val temp = it.split(TAB_STRING)
                if(temp.size != 2) {
                    return@forEachLine
                }
                dialectArrayList.add(temp[0])
                standardArrayList.add(temp[1])
            }
            repeatScriptTextJejuSet1Dialect = dialectArrayList.toTypedArray()
            repeatScriptTextJejuSet1Standard = standardArrayList.toTypedArray()
        } catch (e: Exception) {
            e.printStackTrace()
        }
        // Initialize Repeat text part end..

        // Initialize QnA text part start
        try {
            rawData = context.resources.openRawResource(R.raw.qna_gangwon_1)
            inputStreamReader = InputStreamReader(rawData)
            val questionList = arrayListOf<String>()
            inputStreamReader.forEachLine {
                questionList.add(it)
            }
            qnaScriptTextGangwonSet1 = questionList.toTypedArray()
        } catch (e: Exception) {
            e.printStackTrace()
        }

        try {
            rawData = context.resources.openRawResource(R.raw.qna_chungcheong_1)
            inputStreamReader = InputStreamReader(rawData)
            val questionList = arrayListOf<String>()
            inputStreamReader.forEachLine {
                questionList.add(it)
            }
            qnaScriptTextChungCheongSet1 = questionList.toTypedArray()
        } catch (e: Exception) {
            e.printStackTrace()
        }

        try {
            rawData = context.resources.openRawResource(R.raw.qna_gyeongsang_1)
            inputStreamReader = InputStreamReader(rawData)
            val questionList = arrayListOf<String>()
            inputStreamReader.forEachLine {
                questionList.add(it)
            }
            qnaScriptTextGyeongsangSet1 = questionList.toTypedArray()
        } catch (e: Exception) {
            e.printStackTrace()
        }

        try {
            rawData = context.resources.openRawResource(R.raw.qna_jeonra_1)
            inputStreamReader = InputStreamReader(rawData)
            val questionList = arrayListOf<String>()
            inputStreamReader.forEachLine {
                questionList.add(it)
            }
            qnaScriptTextJeonraSet1 = questionList.toTypedArray()
        } catch (e: Exception) {
            e.printStackTrace()
        }

        try {
            rawData = context.resources.openRawResource(R.raw.qna_jeju_1)
            inputStreamReader = InputStreamReader(rawData)
            val questionList = arrayListOf<String>()
            inputStreamReader.forEachLine {
                questionList.add(it)
            }
            qnaScriptTextJejuSet1 = questionList.toTypedArray()
        } catch (e: Exception) {
            e.printStackTrace()
        }
        // Initialize QnA voice part end..
    }

    fun getRepeatScriptTextDialect(region: String, set: Int): Array<String> {
        return when(region) {
            RegionSelectionViewModel.REGION_GANGWON -> {
                when(set) {
                    1 -> repeatScriptTextGangwonSet1Dialect
                    2 -> repeatScriptTextGangwonSet2Dialect
                    3 -> repeatScriptTextGangwonSet3Dialect
                    else -> arrayOf()
                }
            }
            RegionSelectionViewModel.REGION_CHUNGNAM -> {
                when(set) {
                    1 -> repeatScriptTextChungcheongSet1Dialect
                    2 -> repeatScriptTextChungcheongSet2Dialect
                    3 -> repeatScriptTextChungcheongSet3Dialect
                    else -> arrayOf()
                }
            }
            RegionSelectionViewModel.REGION_CHUNGBUK -> {
                when(set) {
                    1 -> repeatScriptTextChungcheongSet1Dialect
                    2 -> repeatScriptTextChungcheongSet2Dialect
                    3 -> repeatScriptTextChungcheongSet3Dialect
                    else -> arrayOf()
                }
            }
            RegionSelectionViewModel.REGION_GYEONGNAM -> {
                when(set) {
                    1 -> repeatScriptTextGyeongsangSet1Dialect
                    2 -> repeatScriptTextGyeongsangSet2Dialect
                    3 -> repeatScriptTextGyeongsangSet3Dialect
                    else -> arrayOf()
                }
            }
            RegionSelectionViewModel.REGION_GYEONGBUK -> {
                when(set) {
                    1 -> repeatScriptTextGyeongsangSet1Dialect
                    2 -> repeatScriptTextGyeongsangSet2Dialect
                    3 -> repeatScriptTextGyeongsangSet3Dialect
                    else -> arrayOf()
                }
            }
            RegionSelectionViewModel.REGION_JEONNAM -> {
                when(set) {
                    1 -> repeatScriptTextJeonraSet1Dialect
                    2 -> repeatScriptTextJeonraSet2Dialect
                    3 -> repeatScriptTextJeonraSet3Dialect
                    else -> arrayOf()
                }
            }
            RegionSelectionViewModel.REGION_JEONBUK -> {
                when(set) {
                    1 -> repeatScriptTextJeonraSet1Dialect
                    2 -> repeatScriptTextJeonraSet2Dialect
                    3 -> repeatScriptTextJeonraSet3Dialect
                    else -> arrayOf()
                }
            }
            RegionSelectionViewModel.REGION_JEJU -> {
                when(set) {
                    1 -> repeatScriptTextJejuSet1Dialect
                    2 -> repeatScriptTextJejuSet2Dialect
                    3 -> repeatScriptTextJejuSet3Dialect
                    else -> arrayOf()
                }
            }
            else -> arrayOf()
        }
    }

    fun getRepeatScriptTextStandard(region: String, set: Int): Array<String> {
        return when(region) {
            RegionSelectionViewModel.REGION_GANGWON -> {
                when(set) {
                    1 -> repeatScriptTextGangwonSet1Standard
                    2 -> repeatScriptTextGangwonSet2Standard
                    3 -> repeatScriptTextGangwonSet3Standard
                    else -> arrayOf()
                }
            }
            RegionSelectionViewModel.REGION_CHUNGNAM -> {
                when(set) {
                    1 -> repeatScriptTextChungcheongSet1Standard
                    2 -> repeatScriptTextChungcheongSet2Standard
                    3 -> repeatScriptTextChungcheongSet3Standard
                    else -> arrayOf()
                }
            }
            RegionSelectionViewModel.REGION_CHUNGBUK -> {
                when(set) {
                    1 -> repeatScriptTextChungcheongSet1Standard
                    2 -> repeatScriptTextChungcheongSet2Standard
                    3 -> repeatScriptTextChungcheongSet3Standard
                    else -> arrayOf()
                }
            }
            RegionSelectionViewModel.REGION_GYEONGNAM -> {
                when(set) {
                    1 -> repeatScriptTextGyeongsangSet1Standard
                    2 -> repeatScriptTextGyeongsangSet2Standard
                    3 -> repeatScriptTextGyeongsangSet3Standard
                    else -> arrayOf()
                }
            }
            RegionSelectionViewModel.REGION_GYEONGBUK -> {
                when(set) {
                    1 -> repeatScriptTextGyeongsangSet1Standard
                    2 -> repeatScriptTextGyeongsangSet2Standard
                    3 -> repeatScriptTextGyeongsangSet3Standard
                    else -> arrayOf()
                }
            }
            RegionSelectionViewModel.REGION_JEONNAM -> {
                when(set) {
                    1 -> repeatScriptTextJeonraSet1Standard
                    2 -> repeatScriptTextJeonraSet2Standard
                    3 -> repeatScriptTextJeonraSet3Standard
                    else -> arrayOf()
                }
            }
            RegionSelectionViewModel.REGION_JEONBUK -> {
                when(set) {
                    1 -> repeatScriptTextJeonraSet1Standard
                    2 -> repeatScriptTextJeonraSet2Standard
                    3 -> repeatScriptTextJeonraSet3Standard
                    else -> arrayOf()
                }
            }
            RegionSelectionViewModel.REGION_JEJU -> {
                when(set) {
                    1 -> repeatScriptTextJejuSet1Standard
                    2 -> repeatScriptTextJejuSet2Standard
                    3 -> repeatScriptTextJejuSet3Standard
                    else -> arrayOf()
                }
            }
            else -> arrayOf()
        }
    }

    fun getRepeatScriptVoice(region: String, set: Int): Array<Int> {
        return when(region) {
            RegionSelectionViewModel.REGION_GANGWON -> {
                when(set) {
                    1 -> repeatScriptVoiceGangwonSet1
                    2 -> repeatScriptVoiceGangwonSet2
                    3 -> repeatScriptVoiceGangwonSet3
                    else -> arrayOf()
                }
            }
            RegionSelectionViewModel.REGION_CHUNGNAM -> {
                when(set) {
                    1 -> repeatScriptVoiceChungcheongSet1
                    2 -> repeatScriptVoiceChungcheongSet2
                    3 -> repeatScriptVoiceChungcheongSet3
                    else -> arrayOf()
                }
            }
            RegionSelectionViewModel.REGION_CHUNGBUK -> {
                when(set) {
                    1 -> repeatScriptVoiceChungcheongSet1
                    2 -> repeatScriptVoiceChungcheongSet2
                    3 -> repeatScriptVoiceChungcheongSet3
                    else -> arrayOf()
                }
            }
            RegionSelectionViewModel.REGION_GYEONGNAM -> {
                when(set) {
                    1 -> repeatScriptVoiceGyeongsangSet1
                    2 -> repeatScriptVoiceGyeongsangSet2
                    3 -> repeatScriptVoiceGyeongsangSet3
                    else -> arrayOf()
                }
            }
            RegionSelectionViewModel.REGION_GYEONGBUK -> {
                when(set) {
                    1 -> repeatScriptVoiceGyeongsangSet1
                    2 -> repeatScriptVoiceGyeongsangSet2
                    3 -> repeatScriptVoiceGyeongsangSet3
                    else -> arrayOf()
                }
            }
            RegionSelectionViewModel.REGION_JEONNAM -> {
                when(set) {
                    1 -> repeatScriptVoiceJeonraSet1
                    2 -> repeatScriptVoiceJeonraSet2
                    3 -> repeatScriptVoiceJeonraSet3
                    else -> arrayOf()
                }
            }
            RegionSelectionViewModel.REGION_JEONBUK -> {
                when(set) {
                    1 -> repeatScriptVoiceJeonraSet1
                    2 -> repeatScriptVoiceJeonraSet2
                    3 -> repeatScriptVoiceJeonraSet3
                    else -> arrayOf()
                }
            }
            RegionSelectionViewModel.REGION_JEJU -> {
                when(set) {
                    1 -> repeatScriptVoiceJejuSet1
                    2 -> repeatScriptVoiceJejuSet2
                    3 -> repeatScriptVoiceJejuSet3
                    else -> arrayOf()
                }
            }
            else -> arrayOf()
        }
    }
}