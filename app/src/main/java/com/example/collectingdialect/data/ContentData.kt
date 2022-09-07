package com.example.collectingdialect.data

import android.content.Context
import androidx.annotation.RawRes
import com.example.collectingdialect.R
import com.example.collectingdialect.ui.collecting.InfoViewModel
import com.example.collectingdialect.ui.collecting.oneperson.speaker.SpeakerInfoOnePersonViewModel
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
    private var repeatScriptVoiceGangwonSet2 = arrayOf(
        R.raw.gw_2_001, R.raw.gw_2_002, R.raw.gw_2_003, R.raw.gw_2_004, R.raw.gw_2_005, R.raw.gw_2_006, R.raw.gw_2_007, R.raw.gw_2_008, R.raw.gw_2_009, R.raw.gw_2_010, R.raw.gw_2_011, R.raw.gw_2_012, R.raw.gw_2_013, R.raw.gw_2_014, R.raw.gw_2_015, R.raw.gw_2_016, R.raw.gw_2_017, R.raw.gw_2_018, R.raw.gw_2_019, R.raw.gw_2_020, R.raw.gw_2_021, R.raw.gw_2_022, R.raw.gw_2_023, R.raw.gw_2_024, R.raw.gw_2_025, R.raw.gw_2_026, R.raw.gw_2_027, R.raw.gw_2_028, R.raw.gw_2_029, R.raw.gw_2_030, R.raw.gw_2_031, R.raw.gw_2_032, R.raw.gw_2_033, R.raw.gw_2_034, R.raw.gw_2_035, R.raw.gw_2_036, R.raw.gw_2_037, R.raw.gw_2_038, R.raw.gw_2_039, R.raw.gw_2_040, R.raw.gw_2_041, R.raw.gw_2_042, R.raw.gw_2_043, R.raw.gw_2_044, R.raw.gw_2_045, R.raw.gw_2_046, R.raw.gw_2_047, R.raw.gw_2_048, R.raw.gw_2_049, R.raw.gw_2_050, R.raw.gw_2_051, R.raw.gw_2_052, R.raw.gw_2_053, R.raw.gw_2_054, R.raw.gw_2_055, R.raw.gw_2_056, R.raw.gw_2_057, R.raw.gw_2_058, R.raw.gw_2_059, R.raw.gw_2_060, R.raw.gw_2_061, R.raw.gw_2_062, R.raw.gw_2_063, R.raw.gw_2_064, R.raw.gw_2_065, R.raw.gw_2_066, R.raw.gw_2_067, R.raw.gw_2_068, R.raw.gw_2_069, R.raw.gw_2_070, R.raw.gw_2_071, R.raw.gw_2_072, R.raw.gw_2_073, R.raw.gw_2_074, R.raw.gw_2_075, R.raw.gw_2_076, R.raw.gw_2_077, R.raw.gw_2_078, R.raw.gw_2_079, R.raw.gw_2_080, R.raw.gw_2_081, R.raw.gw_2_082, R.raw.gw_2_083, R.raw.gw_2_084, R.raw.gw_2_085, R.raw.gw_2_086, R.raw.gw_2_087, R.raw.gw_2_088, R.raw.gw_2_089, R.raw.gw_2_090, R.raw.gw_2_091, R.raw.gw_2_092, R.raw.gw_2_093, R.raw.gw_2_094, R.raw.gw_2_095, R.raw.gw_2_096, R.raw.gw_2_097, R.raw.gw_2_098, R.raw.gw_2_099, R.raw.gw_2_100, R.raw.gw_2_101, R.raw.gw_2_102, R.raw.gw_2_103, R.raw.gw_2_104, R.raw.gw_2_105, R.raw.gw_2_106, R.raw.gw_2_107,
    )
    private var repeatScriptVoiceGangwonSet3 = arrayOf(
        R.raw.gw_3_001, R.raw.gw_3_002, R.raw.gw_3_003, R.raw.gw_3_004, R.raw.gw_3_005, R.raw.gw_3_006, R.raw.gw_3_007, R.raw.gw_3_008, R.raw.gw_3_009, R.raw.gw_3_010, R.raw.gw_3_011, R.raw.gw_3_012, R.raw.gw_3_013, R.raw.gw_3_014, R.raw.gw_3_015, R.raw.gw_3_016, R.raw.gw_3_017, R.raw.gw_3_018, R.raw.gw_3_019, R.raw.gw_3_020, R.raw.gw_3_021, R.raw.gw_3_022, R.raw.gw_3_023, R.raw.gw_3_024, R.raw.gw_3_025, R.raw.gw_3_026, R.raw.gw_3_027, R.raw.gw_3_028, R.raw.gw_3_029, R.raw.gw_3_030, R.raw.gw_3_031, R.raw.gw_3_032, R.raw.gw_3_033, R.raw.gw_3_034, R.raw.gw_3_035, R.raw.gw_3_036, R.raw.gw_3_037, R.raw.gw_3_038, R.raw.gw_3_039, R.raw.gw_3_040, R.raw.gw_3_041, R.raw.gw_3_042, R.raw.gw_3_043, R.raw.gw_3_044, R.raw.gw_3_045, R.raw.gw_3_046, R.raw.gw_3_047, R.raw.gw_3_048, R.raw.gw_3_049, R.raw.gw_3_050, R.raw.gw_3_051, R.raw.gw_3_052, R.raw.gw_3_053, R.raw.gw_3_054, R.raw.gw_3_055, R.raw.gw_3_056, R.raw.gw_3_057, R.raw.gw_3_058, R.raw.gw_3_059, R.raw.gw_3_060, R.raw.gw_3_061, R.raw.gw_3_062, R.raw.gw_3_063, R.raw.gw_3_064, R.raw.gw_3_065, R.raw.gw_3_066, R.raw.gw_3_067, R.raw.gw_3_068, R.raw.gw_3_069, R.raw.gw_3_070, R.raw.gw_3_071, R.raw.gw_3_072, R.raw.gw_3_073, R.raw.gw_3_074, R.raw.gw_3_075, R.raw.gw_3_076, R.raw.gw_3_077, R.raw.gw_3_078, R.raw.gw_3_079, R.raw.gw_3_080, R.raw.gw_3_081, R.raw.gw_3_082, R.raw.gw_3_083, R.raw.gw_3_084, R.raw.gw_3_085, R.raw.gw_3_086, R.raw.gw_3_087, R.raw.gw_3_088, R.raw.gw_3_089, R.raw.gw_3_090, R.raw.gw_3_091, R.raw.gw_3_092, R.raw.gw_3_093, R.raw.gw_3_094, R.raw.gw_3_095, R.raw.gw_3_096, R.raw.gw_3_097, R.raw.gw_3_098, R.raw.gw_3_099, R.raw.gw_3_100, R.raw.gw_3_101, R.raw.gw_3_102, R.raw.gw_3_103, R.raw.gw_3_104, R.raw.gw_3_105, R.raw.gw_3_106, R.raw.gw_3_107, R.raw.gw_3_108, R.raw.gw_3_109, R.raw.gw_3_110,
    )
    private var repeatScriptVoiceChungcheongSet1 = arrayOf(
        R.raw.cc_1_001, R.raw.cc_1_002, R.raw.cc_1_003, R.raw.cc_1_004, R.raw.cc_1_005, R.raw.cc_1_006, R.raw.cc_1_007, R.raw.cc_1_008, R.raw.cc_1_009, R.raw.cc_1_011, R.raw.cc_1_012, R.raw.cc_1_013, R.raw.cc_1_015, R.raw.cc_1_016, R.raw.cc_1_017, R.raw.cc_1_018, R.raw.cc_1_019, R.raw.cc_1_020, R.raw.cc_1_021, R.raw.cc_1_022, R.raw.cc_1_023, R.raw.cc_1_024, R.raw.cc_1_025, R.raw.cc_1_026, R.raw.cc_1_027, R.raw.cc_1_028, R.raw.cc_1_029, R.raw.cc_1_030, R.raw.cc_1_031, R.raw.cc_1_032, R.raw.cc_1_033, R.raw.cc_1_034, R.raw.cc_1_035, R.raw.cc_1_036, R.raw.cc_1_037, R.raw.cc_1_038, R.raw.cc_1_039, R.raw.cc_1_040, R.raw.cc_1_041, R.raw.cc_1_042, R.raw.cc_1_043, R.raw.cc_1_044, R.raw.cc_1_045, R.raw.cc_1_046, R.raw.cc_1_048, R.raw.cc_1_049, R.raw.cc_1_051, R.raw.cc_1_052, R.raw.cc_1_053, R.raw.cc_1_054, R.raw.cc_1_055, R.raw.cc_1_056, R.raw.cc_1_057, R.raw.cc_1_058, R.raw.cc_1_060, R.raw.cc_1_061, R.raw.cc_1_062, R.raw.cc_1_063, R.raw.cc_1_064, R.raw.cc_1_065, R.raw.cc_1_066, R.raw.cc_1_067, R.raw.cc_1_070, R.raw.cc_1_071, R.raw.cc_1_072, R.raw.cc_1_074, R.raw.cc_1_075, R.raw.cc_1_076, R.raw.cc_1_077, R.raw.cc_1_078, R.raw.cc_1_079, R.raw.cc_1_081, R.raw.cc_1_082, R.raw.cc_1_084, R.raw.cc_1_085, R.raw.cc_1_086, R.raw.cc_1_087, R.raw.cc_1_089, R.raw.cc_1_091, R.raw.cc_1_092, R.raw.cc_1_093, R.raw.cc_1_095, R.raw.cc_1_096, R.raw.cc_1_098, R.raw.cc_1_099, R.raw.cc_1_100, R.raw.cc_1_102, R.raw.cc_1_103, R.raw.cc_1_106, R.raw.cc_1_108, R.raw.cc_1_109, R.raw.cc_1_110
    )
    private var repeatScriptVoiceChungcheongSet2 = arrayOf(
        R.raw.cc_2_001, R.raw.cc_2_002, R.raw.cc_2_003, R.raw.cc_2_004, R.raw.cc_2_005, R.raw.cc_2_006, R.raw.cc_2_007, R.raw.cc_2_008, R.raw.cc_2_009, R.raw.cc_2_010, R.raw.cc_2_011, R.raw.cc_2_012, R.raw.cc_2_013, R.raw.cc_2_014, R.raw.cc_2_015, R.raw.cc_2_016, R.raw.cc_2_017, R.raw.cc_2_018, R.raw.cc_2_019, R.raw.cc_2_020, R.raw.cc_2_021, R.raw.cc_2_022, R.raw.cc_2_023, R.raw.cc_2_024, R.raw.cc_2_025, R.raw.cc_2_026, R.raw.cc_2_027, R.raw.cc_2_028, R.raw.cc_2_029, R.raw.cc_2_030, R.raw.cc_2_031, R.raw.cc_2_032, R.raw.cc_2_033, R.raw.cc_2_034, R.raw.cc_2_035, R.raw.cc_2_036, R.raw.cc_2_037, R.raw.cc_2_038, R.raw.cc_2_039, R.raw.cc_2_040, R.raw.cc_2_041, R.raw.cc_2_042, R.raw.cc_2_043, R.raw.cc_2_044, R.raw.cc_2_045, R.raw.cc_2_046, R.raw.cc_2_047, R.raw.cc_2_048, R.raw.cc_2_049, R.raw.cc_2_050, R.raw.cc_2_051, R.raw.cc_2_052, R.raw.cc_2_053, R.raw.cc_2_054, R.raw.cc_2_055, R.raw.cc_2_056, R.raw.cc_2_057, R.raw.cc_2_058, R.raw.cc_2_059, R.raw.cc_2_060, R.raw.cc_2_061, R.raw.cc_2_062, R.raw.cc_2_063, R.raw.cc_2_064, R.raw.cc_2_065, R.raw.cc_2_066, R.raw.cc_2_067, R.raw.cc_2_068, R.raw.cc_2_069, R.raw.cc_2_070, R.raw.cc_2_071, R.raw.cc_2_072, R.raw.cc_2_073, R.raw.cc_2_074, R.raw.cc_2_075, R.raw.cc_2_076, R.raw.cc_2_077, R.raw.cc_2_078, R.raw.cc_2_079, R.raw.cc_2_080, R.raw.cc_2_081, R.raw.cc_2_082, R.raw.cc_2_083, R.raw.cc_2_084, R.raw.cc_2_085, R.raw.cc_2_086, R.raw.cc_2_087, R.raw.cc_2_088, R.raw.cc_2_090, R.raw.cc_2_091, R.raw.cc_2_092, R.raw.cc_2_093, R.raw.cc_2_094, R.raw.cc_2_095, R.raw.cc_2_096, R.raw.cc_2_097, R.raw.cc_2_098, R.raw.cc_2_099, R.raw.cc_2_101, R.raw.cc_2_102, R.raw.cc_2_103, R.raw.cc_2_104, R.raw.cc_2_105, R.raw.cc_2_106, R.raw.cc_2_107, R.raw.cc_2_108, R.raw.cc_2_109, R.raw.cc_2_110
    )
    private var repeatScriptVoiceChungcheongSet3 = arrayOf(
        R.raw.cc_3_001, R.raw.cc_3_002, R.raw.cc_3_003, R.raw.cc_3_004, R.raw.cc_3_005, R.raw.cc_3_006, R.raw.cc_3_007, R.raw.cc_3_008, R.raw.cc_3_009, R.raw.cc_3_010, R.raw.cc_3_011, R.raw.cc_3_012, R.raw.cc_3_013, R.raw.cc_3_014, R.raw.cc_3_015, R.raw.cc_3_016, R.raw.cc_3_017, R.raw.cc_3_018, R.raw.cc_3_019, R.raw.cc_3_020, R.raw.cc_3_021, R.raw.cc_3_022, R.raw.cc_3_023, R.raw.cc_3_024, R.raw.cc_3_025, R.raw.cc_3_026, R.raw.cc_3_027, R.raw.cc_3_028, R.raw.cc_3_029, R.raw.cc_3_030, R.raw.cc_3_031, R.raw.cc_3_032, R.raw.cc_3_033, R.raw.cc_3_034, R.raw.cc_3_035, R.raw.cc_3_036, R.raw.cc_3_037, R.raw.cc_3_038, R.raw.cc_3_039, R.raw.cc_3_040, R.raw.cc_3_041, R.raw.cc_3_042, R.raw.cc_3_043, R.raw.cc_3_044, R.raw.cc_3_045, R.raw.cc_3_046, R.raw.cc_3_047, R.raw.cc_3_048, R.raw.cc_3_049, R.raw.cc_3_050, R.raw.cc_3_051, R.raw.cc_3_052, R.raw.cc_3_053, R.raw.cc_3_054, R.raw.cc_3_055, R.raw.cc_3_056, R.raw.cc_3_057, R.raw.cc_3_058, R.raw.cc_3_059, R.raw.cc_3_060, R.raw.cc_3_061, R.raw.cc_3_062, R.raw.cc_3_063, R.raw.cc_3_064, R.raw.cc_3_065, R.raw.cc_3_066, R.raw.cc_3_067, R.raw.cc_3_068, R.raw.cc_3_069, R.raw.cc_3_070, R.raw.cc_3_071, R.raw.cc_3_072, R.raw.cc_3_073, R.raw.cc_3_074, R.raw.cc_3_075, R.raw.cc_3_076, R.raw.cc_3_077, R.raw.cc_3_078, R.raw.cc_3_079, R.raw.cc_3_080, R.raw.cc_3_081, R.raw.cc_3_082, R.raw.cc_3_083, R.raw.cc_3_084, R.raw.cc_3_085, R.raw.cc_3_086, R.raw.cc_3_087, R.raw.cc_3_088, R.raw.cc_3_089, R.raw.cc_3_090, R.raw.cc_3_091, R.raw.cc_3_092, R.raw.cc_3_093, R.raw.cc_3_094, R.raw.cc_3_095, R.raw.cc_3_096, R.raw.cc_3_097, R.raw.cc_3_098, R.raw.cc_3_099, R.raw.cc_3_100, R.raw.cc_3_101, R.raw.cc_3_102, R.raw.cc_3_103, R.raw.cc_3_104, R.raw.cc_3_105, R.raw.cc_3_106, R.raw.cc_3_107, R.raw.cc_3_108, R.raw.cc_3_109, R.raw.cc_3_110
    )
    private var repeatScriptVoiceGyeongsangSet1 = arrayOf(
        R.raw.gs_1_001, R.raw.gs_1_002, R.raw.gs_1_003, R.raw.gs_1_004, R.raw.gs_1_005, R.raw.gs_1_006, R.raw.gs_1_007, R.raw.gs_1_008, R.raw.gs_1_009, R.raw.gs_1_010, R.raw.gs_1_011, R.raw.gs_1_012, R.raw.gs_1_013, R.raw.gs_1_014, R.raw.gs_1_015, R.raw.gs_1_016, R.raw.gs_1_017, R.raw.gs_1_018, R.raw.gs_1_019, R.raw.gs_1_020, R.raw.gs_1_021, R.raw.gs_1_022, R.raw.gs_1_023, R.raw.gs_1_024, R.raw.gs_1_025, R.raw.gs_1_026, R.raw.gs_1_027, R.raw.gs_1_028, R.raw.gs_1_029, R.raw.gs_1_030, R.raw.gs_1_031, R.raw.gs_1_032, R.raw.gs_1_033, R.raw.gs_1_034, R.raw.gs_1_035, R.raw.gs_1_036, R.raw.gs_1_037, R.raw.gs_1_038, R.raw.gs_1_039, R.raw.gs_1_040, R.raw.gs_1_041, R.raw.gs_1_042, R.raw.gs_1_043, R.raw.gs_1_044, R.raw.gs_1_045, R.raw.gs_1_046, R.raw.gs_1_047, R.raw.gs_1_048, R.raw.gs_1_049, R.raw.gs_1_050, R.raw.gs_1_051, R.raw.gs_1_052, R.raw.gs_1_053, R.raw.gs_1_054, R.raw.gs_1_055, R.raw.gs_1_056, R.raw.gs_1_057, R.raw.gs_1_058, R.raw.gs_1_059, R.raw.gs_1_060, R.raw.gs_1_061, R.raw.gs_1_062, R.raw.gs_1_063, R.raw.gs_1_064, R.raw.gs_1_065, R.raw.gs_1_066, R.raw.gs_1_067, R.raw.gs_1_068, R.raw.gs_1_069, R.raw.gs_1_070, R.raw.gs_1_071, R.raw.gs_1_072, R.raw.gs_1_073, R.raw.gs_1_074, R.raw.gs_1_075, R.raw.gs_1_076, R.raw.gs_1_077, R.raw.gs_1_078, R.raw.gs_1_079, R.raw.gs_1_080, R.raw.gs_1_081, R.raw.gs_1_082, R.raw.gs_1_083, R.raw.gs_1_084, R.raw.gs_1_085, R.raw.gs_1_086, R.raw.gs_1_087, R.raw.gs_1_088, R.raw.gs_1_089, R.raw.gs_1_090, R.raw.gs_1_091, R.raw.gs_1_092, R.raw.gs_1_093, R.raw.gs_1_094, R.raw.gs_1_095, R.raw.gs_1_096, R.raw.gs_1_097, R.raw.gs_1_098, R.raw.gs_1_099, R.raw.gs_1_100, R.raw.gs_1_101, R.raw.gs_1_102, R.raw.gs_1_103, R.raw.gs_1_104, R.raw.gs_1_105, R.raw.gs_1_106, R.raw.gs_1_107, R.raw.gs_1_108, R.raw.gs_1_109, R.raw.gs_1_110
    )
    private var repeatScriptVoiceGyeongsangSet2 = arrayOf(
        R.raw.gs_2_001, R.raw.gs_2_002, R.raw.gs_2_003, R.raw.gs_2_004, R.raw.gs_2_005, R.raw.gs_2_006, R.raw.gs_2_007, R.raw.gs_2_008, R.raw.gs_2_009, R.raw.gs_2_010, R.raw.gs_2_011, R.raw.gs_2_012, R.raw.gs_2_013, R.raw.gs_2_014, R.raw.gs_2_015, R.raw.gs_2_016, R.raw.gs_2_017, R.raw.gs_2_018, R.raw.gs_2_019, R.raw.gs_2_020, R.raw.gs_2_021, R.raw.gs_2_022, R.raw.gs_2_023, R.raw.gs_2_024, R.raw.gs_2_025, R.raw.gs_2_026, R.raw.gs_2_027, R.raw.gs_2_028, R.raw.gs_2_029, R.raw.gs_2_030, R.raw.gs_2_031, R.raw.gs_2_032, R.raw.gs_2_033, R.raw.gs_2_034, R.raw.gs_2_035, R.raw.gs_2_036, R.raw.gs_2_037, R.raw.gs_2_038, R.raw.gs_2_039, R.raw.gs_2_040, R.raw.gs_2_041, R.raw.gs_2_042, R.raw.gs_2_043, R.raw.gs_2_044, R.raw.gs_2_045, R.raw.gs_2_046, R.raw.gs_2_047, R.raw.gs_2_048, R.raw.gs_2_049, R.raw.gs_2_050, R.raw.gs_2_051, R.raw.gs_2_052, R.raw.gs_2_053, R.raw.gs_2_054, R.raw.gs_2_055, R.raw.gs_2_056, R.raw.gs_2_057, R.raw.gs_2_058, R.raw.gs_2_059, R.raw.gs_2_060, R.raw.gs_2_061, R.raw.gs_2_062, R.raw.gs_2_063, R.raw.gs_2_064, R.raw.gs_2_065, R.raw.gs_2_066, R.raw.gs_2_067, R.raw.gs_2_068, R.raw.gs_2_069, R.raw.gs_2_070, R.raw.gs_2_071, R.raw.gs_2_072, R.raw.gs_2_073, R.raw.gs_2_074, R.raw.gs_2_075, R.raw.gs_2_076, R.raw.gs_2_077, R.raw.gs_2_078, R.raw.gs_2_079, R.raw.gs_2_080, R.raw.gs_2_081, R.raw.gs_2_082, R.raw.gs_2_083, R.raw.gs_2_084, R.raw.gs_2_085, R.raw.gs_2_086, R.raw.gs_2_087, R.raw.gs_2_088, R.raw.gs_2_089, R.raw.gs_2_090, R.raw.gs_2_091, R.raw.gs_2_092, R.raw.gs_2_093, R.raw.gs_2_094, R.raw.gs_2_095, R.raw.gs_2_096, R.raw.gs_2_097, R.raw.gs_2_098, R.raw.gs_2_099, R.raw.gs_2_100, R.raw.gs_2_101, R.raw.gs_2_102, R.raw.gs_2_103, R.raw.gs_2_104, R.raw.gs_2_105, R.raw.gs_2_106, R.raw.gs_2_107, R.raw.gs_2_108,
    )
    private var repeatScriptVoiceGyeongsangSet3 = arrayOf(
        R.raw.gs_3_001, R.raw.gs_3_002, R.raw.gs_3_003, R.raw.gs_3_004, R.raw.gs_3_005, R.raw.gs_3_006, R.raw.gs_3_007, R.raw.gs_3_008, R.raw.gs_3_009, R.raw.gs_3_010, R.raw.gs_3_011, R.raw.gs_3_012, R.raw.gs_3_013, R.raw.gs_3_014, R.raw.gs_3_015, R.raw.gs_3_016, R.raw.gs_3_017, R.raw.gs_3_018, R.raw.gs_3_019, R.raw.gs_3_020, R.raw.gs_3_021, R.raw.gs_3_022, R.raw.gs_3_023, R.raw.gs_3_024, R.raw.gs_3_025, R.raw.gs_3_026, R.raw.gs_3_027, R.raw.gs_3_028, R.raw.gs_3_029, R.raw.gs_3_030, R.raw.gs_3_031, R.raw.gs_3_032, R.raw.gs_3_033, R.raw.gs_3_034, R.raw.gs_3_035, R.raw.gs_3_036, R.raw.gs_3_037, R.raw.gs_3_038, R.raw.gs_3_039, R.raw.gs_3_040, R.raw.gs_3_041, R.raw.gs_3_042, R.raw.gs_3_043, R.raw.gs_3_044, R.raw.gs_3_045, R.raw.gs_3_046, R.raw.gs_3_047, R.raw.gs_3_048, R.raw.gs_3_049, R.raw.gs_3_050, R.raw.gs_3_051, R.raw.gs_3_052, R.raw.gs_3_053, R.raw.gs_3_054, R.raw.gs_3_055, R.raw.gs_3_056, R.raw.gs_3_057, R.raw.gs_3_058, R.raw.gs_3_059, R.raw.gs_3_060, R.raw.gs_3_061, R.raw.gs_3_062, R.raw.gs_3_063, R.raw.gs_3_064, R.raw.gs_3_065, R.raw.gs_3_066, R.raw.gs_3_067, R.raw.gs_3_068, R.raw.gs_3_069, R.raw.gs_3_070, R.raw.gs_3_071, R.raw.gs_3_072, R.raw.gs_3_073, R.raw.gs_3_074, R.raw.gs_3_075, R.raw.gs_3_076, R.raw.gs_3_077, R.raw.gs_3_078, R.raw.gs_3_079, R.raw.gs_3_080, R.raw.gs_3_081, R.raw.gs_3_082, R.raw.gs_3_083, R.raw.gs_3_084, R.raw.gs_3_085, R.raw.gs_3_086, R.raw.gs_3_087, R.raw.gs_3_088, R.raw.gs_3_089, R.raw.gs_3_090, R.raw.gs_3_091, R.raw.gs_3_092, R.raw.gs_3_093, R.raw.gs_3_094, R.raw.gs_3_095, R.raw.gs_3_096, R.raw.gs_3_097, R.raw.gs_3_098, R.raw.gs_3_099, R.raw.gs_3_100, R.raw.gs_3_101, R.raw.gs_3_102, R.raw.gs_3_103, R.raw.gs_3_104, R.raw.gs_3_105, R.raw.gs_3_106, R.raw.gs_3_107, R.raw.gs_3_108, R.raw.gs_3_109, R.raw.gs_3_110,
    )
    private var repeatScriptVoiceJeonraSet1 = arrayOf(
        R.raw.jr_1_001, R.raw.jr_1_002, R.raw.jr_1_003, R.raw.jr_1_004, R.raw.jr_1_005, R.raw.jr_1_006, R.raw.jr_1_007, R.raw.jr_1_008, R.raw.jr_1_009, R.raw.jr_1_010, R.raw.jr_1_011, R.raw.jr_1_012, R.raw.jr_1_013, R.raw.jr_1_014, R.raw.jr_1_015, R.raw.jr_1_016, R.raw.jr_1_017, R.raw.jr_1_018, R.raw.jr_1_019, R.raw.jr_1_020, R.raw.jr_1_021, R.raw.jr_1_022, R.raw.jr_1_023, R.raw.jr_1_024, R.raw.jr_1_025, R.raw.jr_1_026, R.raw.jr_1_027, R.raw.jr_1_028, R.raw.jr_1_029, R.raw.jr_1_030, R.raw.jr_1_031, R.raw.jr_1_032, R.raw.jr_1_033, R.raw.jr_1_034, R.raw.jr_1_035, R.raw.jr_1_036, R.raw.jr_1_037, R.raw.jr_1_038, R.raw.jr_1_039, R.raw.jr_1_040, R.raw.jr_1_041, R.raw.jr_1_042, R.raw.jr_1_043, R.raw.jr_1_044, R.raw.jr_1_045, R.raw.jr_1_046, R.raw.jr_1_047, R.raw.jr_1_048, R.raw.jr_1_049, R.raw.jr_1_050, R.raw.jr_1_051, R.raw.jr_1_052, R.raw.jr_1_053, R.raw.jr_1_054, R.raw.jr_1_055, R.raw.jr_1_056, R.raw.jr_1_057, R.raw.jr_1_058, R.raw.jr_1_059, R.raw.jr_1_060, R.raw.jr_1_061, R.raw.jr_1_062, R.raw.jr_1_063, R.raw.jr_1_064, R.raw.jr_1_065, R.raw.jr_1_066, R.raw.jr_1_067, R.raw.jr_1_068, R.raw.jr_1_069, R.raw.jr_1_070, R.raw.jr_1_071, R.raw.jr_1_072, R.raw.jr_1_073, R.raw.jr_1_074, R.raw.jr_1_075, R.raw.jr_1_076, R.raw.jr_1_077, R.raw.jr_1_078, R.raw.jr_1_079, R.raw.jr_1_080, R.raw.jr_1_081, R.raw.jr_1_082, R.raw.jr_1_083, R.raw.jr_1_084, R.raw.jr_1_085, R.raw.jr_1_086, R.raw.jr_1_087, R.raw.jr_1_088, R.raw.jr_1_089, R.raw.jr_1_090, R.raw.jr_1_091, R.raw.jr_1_092, R.raw.jr_1_093, R.raw.jr_1_094, R.raw.jr_1_095, R.raw.jr_1_096, R.raw.jr_1_097, R.raw.jr_1_098, R.raw.jr_1_099, R.raw.jr_1_100, R.raw.jr_1_101, R.raw.jr_1_102, R.raw.jr_1_103, R.raw.jr_1_104, R.raw.jr_1_105, R.raw.jr_1_106, R.raw.jr_1_107, R.raw.jr_1_108, R.raw.jr_1_109, R.raw.jr_1_110, R.raw.jr_1_111, R.raw.jr_1_112, R.raw.jr_1_113, R.raw.jr_1_114, R.raw.jr_1_115, R.raw.jr_1_116, R.raw.jr_1_117, R.raw.jr_1_118, R.raw.jr_1_119
    )
    private var repeatScriptVoiceJeonraSet2 = arrayOf(
        R.raw.jr_2_001, R.raw.jr_2_002, R.raw.jr_2_003, R.raw.jr_2_004, R.raw.jr_2_005, R.raw.jr_2_006, R.raw.jr_2_007, R.raw.jr_2_008, R.raw.jr_2_009, R.raw.jr_2_010, R.raw.jr_2_011, R.raw.jr_2_012, R.raw.jr_2_013, R.raw.jr_2_014, R.raw.jr_2_015, R.raw.jr_2_016, R.raw.jr_2_017, R.raw.jr_2_018, R.raw.jr_2_019, R.raw.jr_2_020, R.raw.jr_2_021, R.raw.jr_2_022, R.raw.jr_2_023, R.raw.jr_2_024, R.raw.jr_2_025, R.raw.jr_2_026, R.raw.jr_2_027, R.raw.jr_2_028, R.raw.jr_2_029, R.raw.jr_2_030, R.raw.jr_2_031, R.raw.jr_2_032, R.raw.jr_2_033, R.raw.jr_2_034, R.raw.jr_2_035, R.raw.jr_2_036, R.raw.jr_2_037, R.raw.jr_2_038, R.raw.jr_2_039, R.raw.jr_2_040, R.raw.jr_2_041, R.raw.jr_2_042, R.raw.jr_2_043, R.raw.jr_2_044, R.raw.jr_2_045, R.raw.jr_2_046, R.raw.jr_2_047, R.raw.jr_2_048, R.raw.jr_2_049, R.raw.jr_2_050, R.raw.jr_2_051, R.raw.jr_2_052, R.raw.jr_2_053, R.raw.jr_2_054, R.raw.jr_2_055, R.raw.jr_2_056, R.raw.jr_2_057, R.raw.jr_2_058, R.raw.jr_2_059, R.raw.jr_2_060, R.raw.jr_2_061, R.raw.jr_2_062, R.raw.jr_2_063, R.raw.jr_2_064, R.raw.jr_2_065, R.raw.jr_2_066, R.raw.jr_2_067, R.raw.jr_2_068, R.raw.jr_2_069, R.raw.jr_2_070, R.raw.jr_2_071, R.raw.jr_2_072, R.raw.jr_2_073, R.raw.jr_2_074, R.raw.jr_2_075, R.raw.jr_2_076, R.raw.jr_2_077, R.raw.jr_2_078, R.raw.jr_2_079, R.raw.jr_2_080, R.raw.jr_2_081, R.raw.jr_2_082, R.raw.jr_2_083, R.raw.jr_2_084, R.raw.jr_2_085, R.raw.jr_2_086, R.raw.jr_2_087, R.raw.jr_2_088, R.raw.jr_2_089, R.raw.jr_2_090, R.raw.jr_2_091, R.raw.jr_2_092, R.raw.jr_2_093, R.raw.jr_2_094, R.raw.jr_2_095, R.raw.jr_2_096, R.raw.jr_2_097, R.raw.jr_2_098, R.raw.jr_2_099, R.raw.jr_2_100, R.raw.jr_2_101, R.raw.jr_2_102, R.raw.jr_2_103, R.raw.jr_2_104, R.raw.jr_2_105, R.raw.jr_2_106, R.raw.jr_2_107, R.raw.jr_2_108, R.raw.jr_2_109,
    )
    private var repeatScriptVoiceJeonraSet3 = arrayOf(
        R.raw.jr_3_001, R.raw.jr_3_002, R.raw.jr_3_003, R.raw.jr_3_004, R.raw.jr_3_005, R.raw.jr_3_006, R.raw.jr_3_007, R.raw.jr_3_008, R.raw.jr_3_009, R.raw.jr_3_010, R.raw.jr_3_011, R.raw.jr_3_012, R.raw.jr_3_013, R.raw.jr_3_014, R.raw.jr_3_015, R.raw.jr_3_016, R.raw.jr_3_017, R.raw.jr_3_018, R.raw.jr_3_019, R.raw.jr_3_020, R.raw.jr_3_021, R.raw.jr_3_022, R.raw.jr_3_023, R.raw.jr_3_024, R.raw.jr_3_025, R.raw.jr_3_026, R.raw.jr_3_027, R.raw.jr_3_028, R.raw.jr_3_029, R.raw.jr_3_030, R.raw.jr_3_031, R.raw.jr_3_032, R.raw.jr_3_033, R.raw.jr_3_034, R.raw.jr_3_035, R.raw.jr_3_036, R.raw.jr_3_037, R.raw.jr_3_038, R.raw.jr_3_039, R.raw.jr_3_040, R.raw.jr_3_041, R.raw.jr_3_042, R.raw.jr_3_043, R.raw.jr_3_044, R.raw.jr_3_045, R.raw.jr_3_046, R.raw.jr_3_047, R.raw.jr_3_048, R.raw.jr_3_049, R.raw.jr_3_050, R.raw.jr_3_051, R.raw.jr_3_052, R.raw.jr_3_053, R.raw.jr_3_054, R.raw.jr_3_055, R.raw.jr_3_056, R.raw.jr_3_057, R.raw.jr_3_058, R.raw.jr_3_059, R.raw.jr_3_060, R.raw.jr_3_061, R.raw.jr_3_062, R.raw.jr_3_063, R.raw.jr_3_064, R.raw.jr_3_065, R.raw.jr_3_066, R.raw.jr_3_067, R.raw.jr_3_068, R.raw.jr_3_069, R.raw.jr_3_070, R.raw.jr_3_071, R.raw.jr_3_072, R.raw.jr_3_073, R.raw.jr_3_074, R.raw.jr_3_075, R.raw.jr_3_076, R.raw.jr_3_077, R.raw.jr_3_078, R.raw.jr_3_079, R.raw.jr_3_080, R.raw.jr_3_081, R.raw.jr_3_082, R.raw.jr_3_083, R.raw.jr_3_084, R.raw.jr_3_085, R.raw.jr_3_086, R.raw.jr_3_087, R.raw.jr_3_088, R.raw.jr_3_089, R.raw.jr_3_090, R.raw.jr_3_091, R.raw.jr_3_092, R.raw.jr_3_093, R.raw.jr_3_094, R.raw.jr_3_095, R.raw.jr_3_096, R.raw.jr_3_097, R.raw.jr_3_098, R.raw.jr_3_099, R.raw.jr_3_100, R.raw.jr_3_101, R.raw.jr_3_102, R.raw.jr_3_103, R.raw.jr_3_104, R.raw.jr_3_105, R.raw.jr_3_106, R.raw.jr_3_107, R.raw.jr_3_108, R.raw.jr_3_109, R.raw.jr_3_110, R.raw.jr_3_111,
    )
    private var repeatScriptVoiceJejuSet1 = arrayOf(
        R.raw.jj_1_001, R.raw.jj_1_002, R.raw.jj_1_003, R.raw.jj_1_004, R.raw.jj_1_005, R.raw.jj_1_006, R.raw.jj_1_007, R.raw.jj_1_008, R.raw.jj_1_009, R.raw.jj_1_010, R.raw.jj_1_011, R.raw.jj_1_012, R.raw.jj_1_013, R.raw.jj_1_014, R.raw.jj_1_015, R.raw.jj_1_016, R.raw.jj_1_017, R.raw.jj_1_018, R.raw.jj_1_019, R.raw.jj_1_020, R.raw.jj_1_021, R.raw.jj_1_022, R.raw.jj_1_023, R.raw.jj_1_024, R.raw.jj_1_025, R.raw.jj_1_026, R.raw.jj_1_027, R.raw.jj_1_028, R.raw.jj_1_029, R.raw.jj_1_030, R.raw.jj_1_031, R.raw.jj_1_032, R.raw.jj_1_033, R.raw.jj_1_034, R.raw.jj_1_035, R.raw.jj_1_036, R.raw.jj_1_037, R.raw.jj_1_038, R.raw.jj_1_039, R.raw.jj_1_040, R.raw.jj_1_041, R.raw.jj_1_042, R.raw.jj_1_043, R.raw.jj_1_044, R.raw.jj_1_045, R.raw.jj_1_046, R.raw.jj_1_047, R.raw.jj_1_048, R.raw.jj_1_049, R.raw.jj_1_050, R.raw.jj_1_051, R.raw.jj_1_052, R.raw.jj_1_053, R.raw.jj_1_054, R.raw.jj_1_055, R.raw.jj_1_056, R.raw.jj_1_057, R.raw.jj_1_058, R.raw.jj_1_059, R.raw.jj_1_060, R.raw.jj_1_061, R.raw.jj_1_062, R.raw.jj_1_063, R.raw.jj_1_064, R.raw.jj_1_065, R.raw.jj_1_066, R.raw.jj_1_067, R.raw.jj_1_068, R.raw.jj_1_069, R.raw.jj_1_070, R.raw.jj_1_071, R.raw.jj_1_072, R.raw.jj_1_073, R.raw.jj_1_074, R.raw.jj_1_075, R.raw.jj_1_076, R.raw.jj_1_077, R.raw.jj_1_078, R.raw.jj_1_079, R.raw.jj_1_080, R.raw.jj_1_081, R.raw.jj_1_082, R.raw.jj_1_083, R.raw.jj_1_084, R.raw.jj_1_085, R.raw.jj_1_086, R.raw.jj_1_087, R.raw.jj_1_088, R.raw.jj_1_089, R.raw.jj_1_090, R.raw.jj_1_091, R.raw.jj_1_092, R.raw.jj_1_093, R.raw.jj_1_094, R.raw.jj_1_095, R.raw.jj_1_096, R.raw.jj_1_097, R.raw.jj_1_098, R.raw.jj_1_099, R.raw.jj_1_100, R.raw.jj_1_101, R.raw.jj_1_102, R.raw.jj_1_103, R.raw.jj_1_104, R.raw.jj_1_105, R.raw.jj_1_106, R.raw.jj_1_107, R.raw.jj_1_108, R.raw.jj_1_109
    )
    private var repeatScriptVoiceJejuSet2 = arrayOf(
        R.raw.jj_2_001, R.raw.jj_2_002, R.raw.jj_2_003, R.raw.jj_2_004, R.raw.jj_2_005, R.raw.jj_2_006, R.raw.jj_2_007, R.raw.jj_2_008, R.raw.jj_2_009, R.raw.jj_2_010, R.raw.jj_2_011, R.raw.jj_2_012, R.raw.jj_2_013, R.raw.jj_2_014, R.raw.jj_2_015, R.raw.jj_2_016, R.raw.jj_2_017, R.raw.jj_2_018, R.raw.jj_2_019, R.raw.jj_2_020, R.raw.jj_2_021, R.raw.jj_2_022, R.raw.jj_2_023, R.raw.jj_2_024, R.raw.jj_2_025, R.raw.jj_2_026, R.raw.jj_2_027, R.raw.jj_2_028, R.raw.jj_2_029, R.raw.jj_2_030, R.raw.jj_2_031, R.raw.jj_2_032, R.raw.jj_2_033, R.raw.jj_2_034, R.raw.jj_2_035, R.raw.jj_2_036, R.raw.jj_2_037, R.raw.jj_2_038, R.raw.jj_2_039, R.raw.jj_2_040, R.raw.jj_2_041, R.raw.jj_2_042, R.raw.jj_2_043, R.raw.jj_2_044, R.raw.jj_2_045, R.raw.jj_2_046, R.raw.jj_2_047, R.raw.jj_2_048, R.raw.jj_2_049, R.raw.jj_2_050, R.raw.jj_2_051, R.raw.jj_2_052, R.raw.jj_2_053, R.raw.jj_2_054, R.raw.jj_2_055, R.raw.jj_2_056, R.raw.jj_2_057, R.raw.jj_2_058, R.raw.jj_2_059, R.raw.jj_2_060, R.raw.jj_2_061, R.raw.jj_2_062, R.raw.jj_2_063, R.raw.jj_2_064, R.raw.jj_2_065, R.raw.jj_2_066, R.raw.jj_2_067, R.raw.jj_2_068, R.raw.jj_2_069, R.raw.jj_2_070, R.raw.jj_2_071, R.raw.jj_2_072, R.raw.jj_2_073, R.raw.jj_2_074, R.raw.jj_2_075, R.raw.jj_2_076, R.raw.jj_2_077, R.raw.jj_2_078, R.raw.jj_2_079, R.raw.jj_2_080, R.raw.jj_2_081, R.raw.jj_2_082, R.raw.jj_2_083, R.raw.jj_2_084, R.raw.jj_2_085, R.raw.jj_2_086, R.raw.jj_2_087, R.raw.jj_2_088, R.raw.jj_2_089, R.raw.jj_2_090, R.raw.jj_2_091, R.raw.jj_2_092, R.raw.jj_2_093, R.raw.jj_2_094, R.raw.jj_2_095, R.raw.jj_2_096, R.raw.jj_2_097, R.raw.jj_2_098, R.raw.jj_2_099, R.raw.jj_2_100, R.raw.jj_2_101, R.raw.jj_2_102, R.raw.jj_2_103, R.raw.jj_2_104, R.raw.jj_2_105, R.raw.jj_2_106, R.raw.jj_2_107, R.raw.jj_2_108, R.raw.jj_2_109, R.raw.jj_2_110, R.raw.jj_2_111, R.raw.jj_2_112, R.raw.jj_2_113, R.raw.jj_2_114, R.raw.jj_2_115, R.raw.jj_2_116, R.raw.jj_2_117, R.raw.jj_2_118,
    )
    private var repeatScriptVoiceJejuSet3 = arrayOf(
        R.raw.jj_3_001, R.raw.jj_3_002, R.raw.jj_3_003, R.raw.jj_3_004, R.raw.jj_3_005, R.raw.jj_3_006, R.raw.jj_3_007, R.raw.jj_3_008, R.raw.jj_3_009, R.raw.jj_3_010, R.raw.jj_3_011, R.raw.jj_3_012, R.raw.jj_3_013, R.raw.jj_3_014, R.raw.jj_3_015, R.raw.jj_3_016, R.raw.jj_3_017, R.raw.jj_3_018, R.raw.jj_3_019, R.raw.jj_3_020, R.raw.jj_3_021, R.raw.jj_3_022, R.raw.jj_3_023, R.raw.jj_3_024, R.raw.jj_3_025, R.raw.jj_3_026, R.raw.jj_3_027, R.raw.jj_3_028, R.raw.jj_3_029, R.raw.jj_3_030, R.raw.jj_3_031, R.raw.jj_3_032, R.raw.jj_3_033, R.raw.jj_3_034, R.raw.jj_3_035, R.raw.jj_3_036, R.raw.jj_3_037, R.raw.jj_3_038, R.raw.jj_3_039, R.raw.jj_3_040, R.raw.jj_3_041, R.raw.jj_3_042, R.raw.jj_3_043, R.raw.jj_3_044, R.raw.jj_3_045, R.raw.jj_3_046, R.raw.jj_3_047, R.raw.jj_3_048, R.raw.jj_3_049, R.raw.jj_3_050, R.raw.jj_3_051, R.raw.jj_3_052, R.raw.jj_3_053, R.raw.jj_3_054, R.raw.jj_3_055, R.raw.jj_3_056, R.raw.jj_3_057, R.raw.jj_3_058, R.raw.jj_3_059, R.raw.jj_3_060, R.raw.jj_3_061, R.raw.jj_3_062, R.raw.jj_3_063, R.raw.jj_3_064, R.raw.jj_3_065, R.raw.jj_3_066, R.raw.jj_3_067, R.raw.jj_3_068, R.raw.jj_3_069, R.raw.jj_3_070, R.raw.jj_3_071, R.raw.jj_3_072, R.raw.jj_3_073, R.raw.jj_3_074, R.raw.jj_3_075, R.raw.jj_3_076, R.raw.jj_3_077, R.raw.jj_3_078, R.raw.jj_3_079, R.raw.jj_3_080, R.raw.jj_3_081, R.raw.jj_3_082, R.raw.jj_3_083, R.raw.jj_3_084, R.raw.jj_3_085, R.raw.jj_3_086, R.raw.jj_3_087, R.raw.jj_3_088, R.raw.jj_3_089, R.raw.jj_3_090, R.raw.jj_3_091, R.raw.jj_3_092, R.raw.jj_3_093, R.raw.jj_3_094, R.raw.jj_3_095, R.raw.jj_3_096, R.raw.jj_3_097, R.raw.jj_3_098, R.raw.jj_3_099, R.raw.jj_3_100, R.raw.jj_3_101, R.raw.jj_3_102, R.raw.jj_3_103, R.raw.jj_3_104, R.raw.jj_3_105, R.raw.jj_3_106, R.raw.jj_3_107, R.raw.jj_3_108, R.raw.jj_3_109, R.raw.jj_3_110, R.raw.jj_3_111, R.raw.jj_3_112, R.raw.jj_3_113, R.raw.jj_3_114, R.raw.jj_3_115, R.raw.jj_3_116, R.raw.jj_3_117, R.raw.jj_3_118,
    )

    private var qnaScriptTextSet1 = arrayOf<String>()
    private var qnaScriptTextSet2 = arrayOf<String>()
    private var qnaScriptTextSet3 = arrayOf<String>()

    private var conversationScriptTextSet1 = arrayOf<String>()
    private var conversationScriptTextSet2 = arrayOf<String>()
    private var conversationScriptTextSet3 = arrayOf<String>()

    private val conversationImageSet1 = arrayOf(
        R.drawable.conversation_image_1, R.drawable.conversation_image_2, R.drawable.conversation_image_3, R.drawable.conversation_image_4, R.drawable.conversation_image_5, R.drawable.conversation_image_6, R.drawable.conversation_image_7, R.drawable.conversation_image_8, R.drawable.conversation_image_9, R.drawable.conversation_image_10, R.drawable.conversation_image_11, R.drawable.conversation_image_12, R.drawable.conversation_image_13, R.drawable.conversation_image_14, R.drawable.conversation_image_15, R.drawable.conversation_image_16, R.drawable.conversation_image_17, R.drawable.conversation_image_18, R.drawable.conversation_image_19, R.drawable.conversation_image_20, R.drawable.conversation_image_21, R.drawable.conversation_image_22, R.drawable.conversation_image_23, R.drawable.conversation_image_24
    )
    private val conversationImageSet2 = arrayOf<Int>(
        R.drawable.conversation_image_9, R.drawable.conversation_image_10, R.drawable.conversation_image_11, R.drawable.conversation_image_12, R.drawable.conversation_image_13, R.drawable.conversation_image_14, R.drawable.conversation_image_15, R.drawable.conversation_image_16, R.drawable.conversation_image_17, R.drawable.conversation_image_18, R.drawable.conversation_image_19, R.drawable.conversation_image_20, R.drawable.conversation_image_21, R.drawable.conversation_image_22, R.drawable.conversation_image_23, R.drawable.conversation_image_24, R.drawable.conversation_image_1, R.drawable.conversation_image_2, R.drawable.conversation_image_3, R.drawable.conversation_image_4, R.drawable.conversation_image_5, R.drawable.conversation_image_6, R.drawable.conversation_image_7, R.drawable.conversation_image_8,
    )
    private val conversationImageSet3 = arrayOf<Int>(
        R.drawable.conversation_image_17, R.drawable.conversation_image_18, R.drawable.conversation_image_19, R.drawable.conversation_image_20, R.drawable.conversation_image_21, R.drawable.conversation_image_22, R.drawable.conversation_image_23, R.drawable.conversation_image_24, R.drawable.conversation_image_1, R.drawable.conversation_image_2, R.drawable.conversation_image_3, R.drawable.conversation_image_4, R.drawable.conversation_image_5, R.drawable.conversation_image_6, R.drawable.conversation_image_7, R.drawable.conversation_image_8, R.drawable.conversation_image_9, R.drawable.conversation_image_10, R.drawable.conversation_image_11, R.drawable.conversation_image_12, R.drawable.conversation_image_13, R.drawable.conversation_image_14, R.drawable.conversation_image_15, R.drawable.conversation_image_16,
    )

    fun init(context: Context) {
        // Initialize Repeat text part start
        initializeRepeatData(context, R.raw.repeat_gangwon_1).run {
            repeatScriptTextGangwonSet1Dialect = get(KEY_SCRIPT_DIALECT) ?: arrayOf()
            repeatScriptTextGangwonSet1Standard = get(KEY_SCRIPT_STANDARD) ?: arrayOf()
        }
        initializeRepeatData(context, R.raw.repeat_gangwon_2).run {
            repeatScriptTextGangwonSet2Dialect = get(KEY_SCRIPT_DIALECT) ?: arrayOf()
            repeatScriptTextGangwonSet2Standard = get(KEY_SCRIPT_STANDARD) ?: arrayOf()
        }
        initializeRepeatData(context, R.raw.repeat_gangwon_3).run {
            repeatScriptTextGangwonSet3Dialect = get(KEY_SCRIPT_DIALECT) ?: arrayOf()
            repeatScriptTextGangwonSet3Standard = get(KEY_SCRIPT_STANDARD) ?: arrayOf()
        }
        initializeRepeatData(context, R.raw.repeat_chungcheong_1).run {
            repeatScriptTextChungcheongSet1Dialect = get(KEY_SCRIPT_DIALECT) ?: arrayOf()
            repeatScriptTextChungcheongSet1Standard = get(KEY_SCRIPT_STANDARD) ?: arrayOf()
        }
        initializeRepeatData(context, R.raw.repeat_chungcheong_2).run {
            repeatScriptTextChungcheongSet2Dialect = get(KEY_SCRIPT_DIALECT) ?: arrayOf()
            repeatScriptTextChungcheongSet2Standard = get(KEY_SCRIPT_STANDARD) ?: arrayOf()
        }
        initializeRepeatData(context, R.raw.repeat_chungcheong_3).run {
            repeatScriptTextChungcheongSet3Dialect = get(KEY_SCRIPT_DIALECT) ?: arrayOf()
            repeatScriptTextChungcheongSet3Standard = get(KEY_SCRIPT_STANDARD) ?: arrayOf()
        }
        initializeRepeatData(context, R.raw.repeat_gyeongsang_1).run {
            repeatScriptTextGyeongsangSet1Dialect = get(KEY_SCRIPT_DIALECT) ?: arrayOf()
            repeatScriptTextGyeongsangSet1Standard = get(KEY_SCRIPT_STANDARD) ?: arrayOf()
        }
        initializeRepeatData(context, R.raw.repeat_gyeongsang_2).run {
            repeatScriptTextGyeongsangSet2Dialect = get(KEY_SCRIPT_DIALECT) ?: arrayOf()
            repeatScriptTextGyeongsangSet2Standard = get(KEY_SCRIPT_STANDARD) ?: arrayOf()
        }
        initializeRepeatData(context, R.raw.repeat_gyeongsang_3).run {
            repeatScriptTextGyeongsangSet3Dialect = get(KEY_SCRIPT_DIALECT) ?: arrayOf()
            repeatScriptTextGyeongsangSet3Standard = get(KEY_SCRIPT_STANDARD) ?: arrayOf()
        }
        initializeRepeatData(context, R.raw.repeat_jeonra_1).run {
            repeatScriptTextJeonraSet1Dialect = get(KEY_SCRIPT_DIALECT) ?: arrayOf()
            repeatScriptTextJeonraSet1Standard = get(KEY_SCRIPT_STANDARD) ?: arrayOf()
        }
        initializeRepeatData(context, R.raw.repeat_jeonra_2).run {
            repeatScriptTextJeonraSet2Dialect = get(KEY_SCRIPT_DIALECT) ?: arrayOf()
            repeatScriptTextJeonraSet2Standard = get(KEY_SCRIPT_STANDARD) ?: arrayOf()
        }
        initializeRepeatData(context, R.raw.repeat_jeonra_3).run {
            repeatScriptTextJeonraSet3Dialect = get(KEY_SCRIPT_DIALECT) ?: arrayOf()
            repeatScriptTextJeonraSet3Standard = get(KEY_SCRIPT_STANDARD) ?: arrayOf()
        }
        initializeRepeatData(context, R.raw.repeat_jeju_1).run {
            repeatScriptTextJejuSet1Dialect = get(KEY_SCRIPT_DIALECT) ?: arrayOf()
            repeatScriptTextJejuSet1Standard = get(KEY_SCRIPT_STANDARD) ?: arrayOf()
        }
        initializeRepeatData(context, R.raw.repeat_jeju_2).run {
            repeatScriptTextJejuSet2Dialect = get(KEY_SCRIPT_DIALECT) ?: arrayOf()
            repeatScriptTextJejuSet2Standard = get(KEY_SCRIPT_STANDARD) ?: arrayOf()
        }
        initializeRepeatData(context, R.raw.repeat_jeju_3).run {
            repeatScriptTextJejuSet3Dialect = get(KEY_SCRIPT_DIALECT) ?: arrayOf()
            repeatScriptTextJejuSet3Standard = get(KEY_SCRIPT_STANDARD) ?: arrayOf()
        }
        // Initialize Repeat text part end..

        // Initialize QnA text part start
        qnaScriptTextSet1 = initializeQnAData(context, R.raw.qna_1)
        qnaScriptTextSet2 = initializeQnAData(context, R.raw.qna_2)
        qnaScriptTextSet3 = initializeQnAData(context, R.raw.qna_3)
        // Initialize QnA voice part end..

        // Initialize Conversation part start
        conversationScriptTextSet1 = initializeConversationData(context, R.raw.conversation_1)
        conversationScriptTextSet2 = initializeConversationData(context, R.raw.conversation_2)
        conversationScriptTextSet3 = initializeConversationData(context, R.raw.conversation_3)
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
            InfoViewModel.RESIDENCE_PROVINCE_GANGWON_STRING -> {
                when(set) {
                    1 -> repeatScriptTextGangwonSet1Dialect
                    2 -> repeatScriptTextGangwonSet2Dialect
                    3 -> repeatScriptTextGangwonSet3Dialect
                    else -> arrayOf()
                }
            }
            InfoViewModel.RESIDENCE_PROVINCE_CHUNGCHEONG_STRING -> {
                when(set) {
                    1 -> repeatScriptTextChungcheongSet1Dialect
                    2 -> repeatScriptTextChungcheongSet2Dialect
                    3 -> repeatScriptTextChungcheongSet3Dialect
                    else -> arrayOf()
                }
            }
            InfoViewModel.RESIDENCE_PROVINCE_GYEONGSANG_STRING -> {
                when(set) {
                    1 -> repeatScriptTextGyeongsangSet1Dialect
                    2 -> repeatScriptTextGyeongsangSet2Dialect
                    3 -> repeatScriptTextGyeongsangSet3Dialect
                    else -> arrayOf()
                }
            }
            InfoViewModel.RESIDENCE_PROVINCE_JEONRA_STRING -> {
                when(set) {
                    1 -> repeatScriptTextJeonraSet1Dialect
                    2 -> repeatScriptTextJeonraSet2Dialect
                    3 -> repeatScriptTextJeonraSet3Dialect
                    else -> arrayOf()
                }
            }
            InfoViewModel.RESIDENCE_PROVINCE_JEJU_STRING -> {
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
            InfoViewModel.RESIDENCE_PROVINCE_GANGWON_STRING -> {
                when(set) {
                    1 -> repeatScriptTextGangwonSet1Standard
                    2 -> repeatScriptTextGangwonSet2Standard
                    3 -> repeatScriptTextGangwonSet3Standard
                    else -> arrayOf()
                }
            }
            InfoViewModel.RESIDENCE_PROVINCE_CHUNGCHEONG_STRING -> {
                when(set) {
                    1 -> repeatScriptTextChungcheongSet1Standard
                    2 -> repeatScriptTextChungcheongSet2Standard
                    3 -> repeatScriptTextChungcheongSet3Standard
                    else -> arrayOf()
                }
            }
            InfoViewModel.RESIDENCE_PROVINCE_GYEONGSANG_STRING -> {
                when(set) {
                    1 -> repeatScriptTextGyeongsangSet1Standard
                    2 -> repeatScriptTextGyeongsangSet2Standard
                    3 -> repeatScriptTextGyeongsangSet3Standard
                    else -> arrayOf()
                }
            }
            InfoViewModel.RESIDENCE_PROVINCE_JEONRA_STRING -> {
                when(set) {
                    1 -> repeatScriptTextJeonraSet1Standard
                    2 -> repeatScriptTextJeonraSet2Standard
                    3 -> repeatScriptTextJeonraSet3Standard
                    else -> arrayOf()
                }
            }
            InfoViewModel.RESIDENCE_PROVINCE_JEJU_STRING -> {
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
            InfoViewModel.RESIDENCE_PROVINCE_GANGWON_STRING -> {
                when(set) {
                    1 -> repeatScriptVoiceGangwonSet1
                    2 -> repeatScriptVoiceGangwonSet2
                    3 -> repeatScriptVoiceGangwonSet3
                    else -> arrayOf()
                }
            }
            InfoViewModel.RESIDENCE_PROVINCE_CHUNGCHEONG_STRING -> {
                when(set) {
                    1 -> repeatScriptVoiceChungcheongSet1
                    2 -> repeatScriptVoiceChungcheongSet2
                    3 -> repeatScriptVoiceChungcheongSet3
                    else -> arrayOf()
                }
            }
            InfoViewModel.RESIDENCE_PROVINCE_GYEONGSANG_STRING -> {
                when(set) {
                    1 -> repeatScriptVoiceGyeongsangSet1
                    2 -> repeatScriptVoiceGyeongsangSet2
                    3 -> repeatScriptVoiceGyeongsangSet3
                    else -> arrayOf()
                }
            }
            InfoViewModel.RESIDENCE_PROVINCE_JEONRA_STRING -> {
                when(set) {
                    1 -> repeatScriptVoiceJeonraSet1
                    2 -> repeatScriptVoiceJeonraSet2
                    3 -> repeatScriptVoiceJeonraSet3
                    else -> arrayOf()
                }
            }
            InfoViewModel.RESIDENCE_PROVINCE_JEJU_STRING -> {
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

    fun getQnAScriptText(set: Int?): Array<String> {
        return when(set) {
            1 -> qnaScriptTextSet1
            2 -> qnaScriptTextSet2
            3 -> qnaScriptTextSet3
            else -> arrayOf()
        }
    }

    fun getConversationScriptText(set: Int?): Array<String> {
        return when(set) {
            1 -> conversationScriptTextSet1
            2 -> conversationScriptTextSet2
            3 -> conversationScriptTextSet3
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
}