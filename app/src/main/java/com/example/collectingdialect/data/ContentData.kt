package com.example.collectingdialect.data

import android.content.Context
import androidx.annotation.RawRes
import com.example.collectingdialect.R
import com.example.collectingdialect.ui.content.region.RegionSelectionViewModel
import java.io.InputStreamReader

object ContentData {
    private const val TAB_STRING = "    "
    private const val KEY_SCRIPT_DIALECT = "dialect"
    private const val KEY_SCRIPT_STANDARD = "standard"

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
        R.raw.gs_1_001, R.raw.gs_1_002, R.raw.gs_1_003, R.raw.gs_1_004, R.raw.gs_1_005, R.raw.gs_1_006, R.raw.gs_1_007, R.raw.gs_1_008, R.raw.gs_1_009, R.raw.gs_1_010, R.raw.gs_1_011, R.raw.gs_1_012, R.raw.gs_1_013, R.raw.gs_1_014, R.raw.gs_1_015, R.raw.gs_1_016, R.raw.gs_1_017, R.raw.gs_1_018, R.raw.gs_1_019, R.raw.gs_1_020, R.raw.gs_1_021, R.raw.gs_1_022, R.raw.gs_1_023, R.raw.gs_1_024, R.raw.gs_1_025, R.raw.gs_1_026, R.raw.gs_1_027, R.raw.gs_1_028, R.raw.gs_1_029, R.raw.gs_1_030, R.raw.gs_1_031, R.raw.gs_1_032, R.raw.gs_1_033, R.raw.gs_1_034, R.raw.gs_1_035, R.raw.gs_1_036, R.raw.gs_1_037, R.raw.gs_1_038, R.raw.gs_1_039, R.raw.gs_1_040, R.raw.gs_1_041, R.raw.gs_1_042, R.raw.gs_1_043, R.raw.gs_1_044, R.raw.gs_1_045, R.raw.gs_1_046, R.raw.gs_1_047, R.raw.gs_1_048, R.raw.gs_1_049, R.raw.gs_1_050, R.raw.gs_1_051, R.raw.gs_1_052, R.raw.gs_1_053, R.raw.gs_1_054, R.raw.gs_1_055, R.raw.gs_1_056, R.raw.gs_1_057, R.raw.gs_1_058, R.raw.gs_1_059, R.raw.gs_1_060, R.raw.gs_1_061, R.raw.gs_1_062, R.raw.gs_1_063, R.raw.gs_1_064, R.raw.gs_1_065, R.raw.gs_1_066, R.raw.gs_1_067, R.raw.gs_1_068, R.raw.gs_1_069, R.raw.gs_1_070, R.raw.gs_1_071, R.raw.gs_1_072, R.raw.gs_1_073, R.raw.gs_1_074, R.raw.gs_1_075, R.raw.gs_1_076, R.raw.gs_1_077, R.raw.gs_1_078, R.raw.gs_1_079, R.raw.gs_1_080, R.raw.gs_1_081, R.raw.gs_1_082, R.raw.gs_1_083, R.raw.gs_1_084, R.raw.gs_1_085, R.raw.gs_1_086, R.raw.gs_1_087, R.raw.gs_1_088, R.raw.gs_1_089, R.raw.gs_1_090, R.raw.gs_1_091, R.raw.gs_1_092, R.raw.gs_1_093, R.raw.gs_1_094, R.raw.gs_1_095, R.raw.gs_1_096, R.raw.gs_1_097, R.raw.gs_1_098, R.raw.gs_1_099, R.raw.gs_1_100, R.raw.gs_1_101, R.raw.gs_1_102, R.raw.gs_1_103, R.raw.gs_1_104, R.raw.gs_1_105, R.raw.gs_1_106, R.raw.gs_1_107, R.raw.gs_1_108, R.raw.gs_1_109, R.raw.gs_1_110
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
    private var qnaScriptTextChungcheongSet1 = arrayOf<String>()
    private var qnaScriptTextChungcheongSet2 = arrayOf<String>()
    private var qnaScriptTextChungcheongSet3 = arrayOf<String>()
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
    private var conversationScriptTextChungcheongSet1 = arrayOf<String>()
    private var conversationScriptTextChungcheongSet2 = arrayOf<String>()
    private var conversationScriptTextChungcheongSet3 = arrayOf<String>()
    private var conversationScriptTextGyeongsangSet1 = arrayOf<String>()
    private var conversationScriptTextGyeongsangSet2 = arrayOf<String>()
    private var conversationScriptTextGyeongsangSet3 = arrayOf<String>()
    private var conversationScriptTextJeonraSet1 = arrayOf<String>()
    private var conversationScriptTextJeonraSet2 = arrayOf<String>()
    private var conversationScriptTextJeonraSet3 = arrayOf<String>()
    private var conversationScriptTextJejuSet1 = arrayOf<String>()
    private var conversationScriptTextJejuSet2 = arrayOf<String>()
    private var conversationScriptTextJejuSet3 = arrayOf<String>()

    private val conversationImageSet1 = arrayOf(
        R.drawable.conversation_image_1, R.drawable.conversation_image_2, R.drawable.conversation_image_3, R.drawable.conversation_image_4, R.drawable.conversation_image_5, R.drawable.conversation_image_6, R.drawable.conversation_image_7, R.drawable.conversation_image_8, R.drawable.conversation_image_9, R.drawable.conversation_image_10, R.drawable.conversation_image_11, R.drawable.conversation_image_12, R.drawable.conversation_image_13, R.drawable.conversation_image_14, R.drawable.conversation_image_15, R.drawable.conversation_image_16, R.drawable.conversation_image_17, R.drawable.conversation_image_18, R.drawable.conversation_image_19, R.drawable.conversation_image_20, R.drawable.conversation_image_21, R.drawable.conversation_image_22, R.drawable.conversation_image_23, R.drawable.conversation_image_24
    )
    private val conversationImageSet2 = arrayOf<Int>()
    private val conversationImageSet3 = arrayOf<Int>()

    fun init(context: Context) {
        // Initialize Repeat text part start
        initializeRepeatData(context, R.raw.repeat_gangwon_1).run {
            repeatScriptTextGangwonSet1Dialect = get(KEY_SCRIPT_DIALECT) ?: arrayOf()
            repeatScriptTextGangwonSet1Standard = get(KEY_SCRIPT_STANDARD) ?: arrayOf()
        }
        initializeRepeatData(context, R.raw.repeat_chungcheong_1).run {
            repeatScriptTextChungcheongSet1Dialect = get(KEY_SCRIPT_DIALECT) ?: arrayOf()
            repeatScriptTextChungcheongSet1Standard = get(KEY_SCRIPT_STANDARD) ?: arrayOf()
        }
        initializeRepeatData(context, R.raw.repeat_gyeongsang_1).run {
            repeatScriptTextGyeongsangSet1Dialect = get(KEY_SCRIPT_DIALECT) ?: arrayOf()
            repeatScriptTextGyeongsangSet1Standard = get(KEY_SCRIPT_STANDARD) ?: arrayOf()
        }
        initializeRepeatData(context, R.raw.repeat_jeonra_1).run {
            repeatScriptTextJeonraSet1Dialect = get(KEY_SCRIPT_DIALECT) ?: arrayOf()
            repeatScriptTextJeonraSet1Standard = get(KEY_SCRIPT_STANDARD) ?: arrayOf()
        }
        initializeRepeatData(context, R.raw.repeat_jeju_1).run {
            repeatScriptTextJejuSet1Dialect = get(KEY_SCRIPT_DIALECT) ?: arrayOf()
            repeatScriptTextJejuSet1Standard = get(KEY_SCRIPT_STANDARD) ?: arrayOf()
        }
        // Initialize Repeat text part end..

        // Initialize QnA text part start
        qnaScriptTextGangwonSet1 = initializeQnAData(context, R.raw.qna_gangwon_1)
        qnaScriptTextChungcheongSet1 = initializeQnAData(context, R.raw.qna_chungcheong_1)
        qnaScriptTextGyeongsangSet1 = initializeQnAData(context, R.raw.qna_gyeongsang_1)
        qnaScriptTextJeonraSet1 = initializeQnAData(context, R.raw.qna_jeonra_1)
        qnaScriptTextJejuSet1 = initializeQnAData(context, R.raw.qna_jeju_1)
        // Initialize QnA voice part end..

        // Initialize Conversation part start
        conversationScriptTextGangwonSet1 = initializeConversationData(context, R.raw.conversation_gangwon_1)
        conversationScriptTextChungcheongSet1 = initializeConversationData(context, R.raw.conversation_chungcheong_1)
        conversationScriptTextGyeongsangSet1 = initializeConversationData(context, R.raw.conversation_gyeongsang_1)
        conversationScriptTextJeonraSet1 = initializeConversationData(context, R.raw.conversation_jeonra_1)
        conversationScriptTextJejuSet1 = initializeConversationData(context, R.raw.conversation_jeju_1)
        // Initialize Conversation part end..
    }

    private fun initializeRepeatData(context: Context, @RawRes resId: Int): Map<String, Array<String>> {
        return try {
            val rawData = context.resources.openRawResource(resId)
            val inputStreamReader = InputStreamReader(rawData)
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
            val dialectArray = dialectArrayList.toTypedArray()
            val standardArray = standardArrayList.toTypedArray()
            mapOf(KEY_SCRIPT_DIALECT to dialectArray, KEY_SCRIPT_STANDARD to standardArray)
        } catch (e: Exception) {
            e.printStackTrace()
            mapOf()
        }
    }

    private fun initializeQnAData(context: Context, @RawRes resId: Int): Array<String> {
        return try {
            val rawData = context.resources.openRawResource(resId)
            val inputStreamReader = InputStreamReader(rawData)
            val questionList = arrayListOf<String>()
            inputStreamReader.forEachLine {
                questionList.add(it)
            }
            questionList.toTypedArray()
        } catch (e: Exception) {
            e.printStackTrace()
            arrayOf()
        }
    }

    private fun initializeConversationData(context: Context, @RawRes resId: Int): Array<String> {
        return try {
            val rawData = context.resources.openRawResource(resId)
            val inputStreamReader = InputStreamReader(rawData)
            val scriptList = arrayListOf<String>()
            inputStreamReader.forEachLine {
                val temp = it.split(TAB_STRING)
                if(temp.size < 2) {
                    scriptList.add(it)
                } else {
                    var chunkString = ""
                    temp.forEach { chunk ->
                        chunkString += chunk
                        chunkString += "\n"
                    }
                    scriptList.add(chunkString)
                }
            }
            scriptList.toTypedArray()
        } catch (e: Exception) {
            e.printStackTrace()
            arrayOf()
        }
    }

    fun getRepeatScriptTextDialect(region: String?, set: Int?): Array<String> {
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

    fun getRepeatScriptTextStandard(region: String?, set: Int?): Array<String> {
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

    fun getRepeatScriptVoice(region: String?, set: Int?): Array<Int> {
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

    fun getQnAScriptText(region: String?, set: Int?): Array<String> {
        return when(region) {
            RegionSelectionViewModel.REGION_GANGWON -> {
                when(set) {
                    1 -> qnaScriptTextGangwonSet1
                    2 -> qnaScriptTextGangwonSet2
                    3 -> qnaScriptTextGangwonSet3
                    else -> arrayOf()
                }
            }
            RegionSelectionViewModel.REGION_CHUNGNAM -> {
                when(set) {
                    1 -> qnaScriptTextChungcheongSet1
                    2 -> qnaScriptTextChungcheongSet2
                    3 -> qnaScriptTextChungcheongSet3
                    else -> arrayOf()
                }
            }
            RegionSelectionViewModel.REGION_CHUNGBUK -> {
                when(set) {
                    1 -> qnaScriptTextChungcheongSet1
                    2 -> qnaScriptTextChungcheongSet2
                    3 -> qnaScriptTextChungcheongSet3
                    else -> arrayOf()
                }
            }
            RegionSelectionViewModel.REGION_GYEONGNAM -> {
                when(set) {
                    1 -> qnaScriptTextGyeongsangSet1
                    2 -> qnaScriptTextGyeongsangSet2
                    3 -> qnaScriptTextGyeongsangSet3
                    else -> arrayOf()
                }
            }
            RegionSelectionViewModel.REGION_GYEONGBUK -> {
                when(set) {
                    1 -> qnaScriptTextGyeongsangSet1
                    2 -> qnaScriptTextGyeongsangSet2
                    3 -> qnaScriptTextGyeongsangSet3
                    else -> arrayOf()
                }
            }
            RegionSelectionViewModel.REGION_JEONNAM -> {
                when(set) {
                    1 -> qnaScriptTextJeonraSet1
                    2 -> qnaScriptTextJeonraSet2
                    3 -> qnaScriptTextJeonraSet3
                    else -> arrayOf()
                }
            }
            RegionSelectionViewModel.REGION_JEONBUK -> {
                when(set) {
                    1 -> qnaScriptTextJeonraSet1
                    2 -> qnaScriptTextJeonraSet2
                    3 -> qnaScriptTextJeonraSet3
                    else -> arrayOf()
                }
            }
            RegionSelectionViewModel.REGION_JEJU -> {
                when(set) {
                    1 -> qnaScriptTextJejuSet1
                    2 -> qnaScriptTextJejuSet2
                    3 -> qnaScriptTextJejuSet3
                    else -> arrayOf()
                }
            }
            else -> arrayOf()
        }
    }

    fun getConversationScriptText(region: String?, set: Int?): Array<String> {
        return when(region) {
            RegionSelectionViewModel.REGION_GANGWON -> {
                when(set) {
                    1 -> conversationScriptTextGangwonSet1
                    2 -> conversationScriptTextGangwonSet2
                    3 -> conversationScriptTextGangwonSet3
                    else -> arrayOf()
                }
            }
            RegionSelectionViewModel.REGION_CHUNGNAM -> {
                when(set) {
                    1 -> conversationScriptTextChungcheongSet1
                    2 -> conversationScriptTextChungcheongSet2
                    3 -> conversationScriptTextChungcheongSet3
                    else -> arrayOf()
                }
            }
            RegionSelectionViewModel.REGION_CHUNGBUK -> {
                when(set) {
                    1 -> conversationScriptTextChungcheongSet1
                    2 -> conversationScriptTextChungcheongSet2
                    3 -> conversationScriptTextChungcheongSet3
                    else -> arrayOf()
                }
            }
            RegionSelectionViewModel.REGION_GYEONGNAM -> {
                when(set) {
                    1 -> conversationScriptTextGyeongsangSet1
                    2 -> conversationScriptTextGyeongsangSet2
                    3 -> conversationScriptTextGyeongsangSet3
                    else -> arrayOf()
                }
            }
            RegionSelectionViewModel.REGION_GYEONGBUK -> {
                when(set) {
                    1 -> conversationScriptTextGyeongsangSet1
                    2 -> conversationScriptTextGyeongsangSet2
                    3 -> conversationScriptTextGyeongsangSet3
                    else -> arrayOf()
                }
            }
            RegionSelectionViewModel.REGION_JEONNAM -> {
                when(set) {
                    1 -> conversationScriptTextJeonraSet1
                    2 -> conversationScriptTextJeonraSet2
                    3 -> conversationScriptTextJeonraSet3
                    else -> arrayOf()
                }
            }
            RegionSelectionViewModel.REGION_JEONBUK -> {
                when(set) {
                    1 -> conversationScriptTextJeonraSet1
                    2 -> conversationScriptTextJeonraSet2
                    3 -> conversationScriptTextJeonraSet3
                    else -> arrayOf()
                }
            }
            RegionSelectionViewModel.REGION_JEJU -> {
                when(set) {
                    1 -> conversationScriptTextJejuSet1
                    2 -> conversationScriptTextJejuSet2
                    3 -> conversationScriptTextJejuSet3
                    else -> arrayOf()
                }
            }
            else -> arrayOf()
        }
    }

    fun getConversationImage(set: Int?): Array<Int> {
        return when(set) {
            1 -> conversationImageSet1
            2 -> conversationImageSet2
            3 -> conversationImageSet3
            else -> arrayOf()
        }
    }

    fun getRequireRecordCountTypeOnePerson(region: String?, set: Int?): Int {
        return when(region) {
            RegionSelectionViewModel.REGION_GANGWON -> {
                when(set) {
                    1 -> repeatScriptTextGangwonSet1Dialect.size + qnaScriptTextGangwonSet1.size
                    2 -> repeatScriptTextGangwonSet2Dialect.size + qnaScriptTextGangwonSet2.size
                    3 -> repeatScriptTextGangwonSet3Dialect.size + qnaScriptTextGangwonSet3.size
                    else -> 0
                }
            }
            RegionSelectionViewModel.REGION_CHUNGNAM -> {
                when(set) {
                    1 -> repeatScriptTextChungcheongSet1Dialect.size + qnaScriptTextChungcheongSet1.size
                    2 -> repeatScriptTextChungcheongSet2Dialect.size + qnaScriptTextChungcheongSet2.size
                    3 -> repeatScriptTextChungcheongSet3Dialect.size + qnaScriptTextChungcheongSet3.size
                    else -> 0
                }
            }
            RegionSelectionViewModel.REGION_CHUNGBUK -> {
                when(set) {
                    1 -> repeatScriptTextChungcheongSet1Dialect.size + qnaScriptTextChungcheongSet1.size
                    2 -> repeatScriptTextChungcheongSet2Dialect.size + qnaScriptTextChungcheongSet2.size
                    3 -> repeatScriptTextChungcheongSet3Dialect.size + qnaScriptTextChungcheongSet3.size
                    else -> 0
                }
            }
            RegionSelectionViewModel.REGION_GYEONGNAM -> {
                when(set) {
                    1 -> repeatScriptTextGyeongsangSet1Dialect.size + qnaScriptTextGyeongsangSet1.size
                    2 -> repeatScriptTextGyeongsangSet2Dialect.size + qnaScriptTextGyeongsangSet2.size
                    3 -> repeatScriptTextGyeongsangSet3Dialect.size + qnaScriptTextGyeongsangSet3.size
                    else -> 0
                }
            }
            RegionSelectionViewModel.REGION_GYEONGBUK -> {
                when(set) {
                    1 -> repeatScriptTextGyeongsangSet1Dialect.size + qnaScriptTextGyeongsangSet1.size
                    2 -> repeatScriptTextGyeongsangSet2Dialect.size + qnaScriptTextGyeongsangSet2.size
                    3 -> repeatScriptTextGyeongsangSet3Dialect.size + qnaScriptTextGyeongsangSet3.size
                    else -> 0
                }
            }
            RegionSelectionViewModel.REGION_JEONNAM -> {
                when(set) {
                    1 -> repeatScriptTextJeonraSet1Dialect.size + qnaScriptTextJeonraSet1.size
                    2 -> repeatScriptTextJeonraSet2Dialect.size + qnaScriptTextJeonraSet2.size
                    3 -> repeatScriptTextJeonraSet3Dialect.size + qnaScriptTextJeonraSet3.size
                    else -> 0
                }
            }
            RegionSelectionViewModel.REGION_JEONBUK -> {
                when(set) {
                    1 -> repeatScriptTextJeonraSet1Dialect.size + qnaScriptTextJeonraSet1.size
                    2 -> repeatScriptTextJeonraSet2Dialect.size + qnaScriptTextJeonraSet2.size
                    3 -> repeatScriptTextJeonraSet3Dialect.size + qnaScriptTextJeonraSet3.size
                    else -> 0
                }
            }
            RegionSelectionViewModel.REGION_JEJU -> {
                when(set) {
                    1 -> repeatScriptTextJejuSet1Dialect.size + qnaScriptTextJejuSet1.size
                    2 -> repeatScriptTextJejuSet2Dialect.size + qnaScriptTextJejuSet2.size
                    3 -> repeatScriptTextJejuSet3Dialect.size + qnaScriptTextJejuSet3.size
                    else -> 0
                }
            }
            else -> 0
        }
    }

    fun getRequireRecordCountTypeTwoPerson(region: String?, set: Int?): Int {
        return when(region) {
            RegionSelectionViewModel.REGION_GANGWON -> {
                when(set) {
                    1 -> conversationScriptTextGangwonSet1.size
                    2 -> conversationScriptTextGangwonSet2.size
                    3 -> conversationScriptTextGangwonSet3.size
                    else -> 0
                }
            }
            RegionSelectionViewModel.REGION_CHUNGNAM -> {
                when(set) {
                    1 -> conversationScriptTextChungcheongSet1.size
                    2 -> conversationScriptTextChungcheongSet2.size
                    3 -> conversationScriptTextChungcheongSet3.size
                    else -> 0
                }
            }
            RegionSelectionViewModel.REGION_CHUNGBUK -> {
                when(set) {
                    1 -> conversationScriptTextChungcheongSet1.size
                    2 -> conversationScriptTextChungcheongSet2.size
                    3 -> conversationScriptTextChungcheongSet3.size
                    else -> 0
                }
            }
            RegionSelectionViewModel.REGION_GYEONGNAM -> {
                when(set) {
                    1 -> conversationScriptTextGyeongsangSet1.size
                    2 -> conversationScriptTextGyeongsangSet2.size
                    3 -> conversationScriptTextGyeongsangSet3.size
                    else -> 0
                }
            }
            RegionSelectionViewModel.REGION_GYEONGBUK -> {
                when(set) {
                    1 -> conversationScriptTextGyeongsangSet1.size
                    2 -> conversationScriptTextGyeongsangSet2.size
                    3 -> conversationScriptTextGyeongsangSet3.size
                    else -> 0
                }
            }
            RegionSelectionViewModel.REGION_JEONNAM -> {
                when(set) {
                    1 -> conversationScriptTextJeonraSet1.size
                    2 -> conversationScriptTextJeonraSet2.size
                    3 -> conversationScriptTextJeonraSet3.size
                    else -> 0
                }
            }
            RegionSelectionViewModel.REGION_JEONBUK -> {
                when(set) {
                    1 -> conversationScriptTextJeonraSet1.size
                    2 -> conversationScriptTextJeonraSet2.size
                    3 -> conversationScriptTextJeonraSet3.size
                    else -> 0
                }
            }
            RegionSelectionViewModel.REGION_JEJU -> {
                when(set) {
                    1 -> conversationScriptTextJejuSet1.size
                    2 -> conversationScriptTextJejuSet2.size
                    3 -> conversationScriptTextJejuSet3.size
                    else -> 0
                }
            }
            else -> 0
        }
    }
}