package com.example.music_store.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.music_store.R

data class Instruments(
    @DrawableRes val image: Int,
    @StringRes val name: Int,
    val purchaseList: List<Purchase>
)

data class Purchase(
    @DrawableRes val image: Int,
    @StringRes val name: Int,
    val price: Int
)

val AcousticGuitars = listOf<Purchase>(
    Purchase(image = R.drawable.western_guitar, name = R.string.western, price = 200),
    Purchase(image = R.drawable.grand_auditorium, name = R.string.grand, price = 250),
    Purchase(image = R.drawable._12_string, name = R.string._12_str, price = 350)
)

val ElectricGuitars = listOf<Purchase>(
    Purchase(image = R.drawable.telecaster, name = R.string.telecaster, price = 200),
    Purchase(image = R.drawable.stratocaster, name = R.string.stratocaster, price = 180),
    Purchase(image = R.drawable._8_str, name = R.string._8_string, price = 400)
)

val Basses = listOf<Purchase>(
    Purchase(image = R.drawable.electro_bass, name = R.string.electric_bass, price = 200),
    Purchase(image = R.drawable.acoustic_bass, name = R.string.acoustic_bass, price = 250)
)

val AcousticDrums = listOf<Purchase>(
    Purchase(image = R.drawable.full_drum_kit, name = R.string.full_drums, price = 1000),
    Purchase(image = R.drawable.mini_drum_kit, name = R.string.mini_drums, price = 800)
)

val ElectronicDrums = listOf<Purchase>(
    Purchase(image = R.drawable.electric_drums, name = R.string.electronic_drums, price = 500),
    Purchase(image = R.drawable.drum_multipad, name = R.string.drum_multipad, price = 400)
)

val ElectronicPiano = listOf<Purchase>(
    Purchase(image = R.drawable.electronic_piano, name = R.string.electronic_piano_1, price = 200),
    Purchase(image = R.drawable.electronic_piano2, name = R.string.electronic_piano_2, price = 250),
)

val Keyboards = listOf<Purchase>(
    Purchase(image = R.drawable.midi_keyboard, name = R.string.midi_piano_1, price = 150),
    Purchase(image = R.drawable.midi_keyboard2, name = R.string.midi_piano_2, price = 200)
)

val Pianos = listOf<Purchase>(
    Purchase(image = R.drawable.piano_1, name = R.string.piano_1, price = 500),
    Purchase(image = R.drawable.piano_2, name = R.string.piano_2, price = 650)
)

val Synths = listOf<Purchase>(
    Purchase(image = R.drawable.analog_synth, name = R.string.analog_synth, price = 550),
    Purchase(image = R.drawable.digital_synth, name = R.string.digital_synth, price = 300)
)

val stringInstruments = listOf<Instruments>(
    Instruments(image = R.drawable.acoustic_guitar, name = R.string.strings1, AcousticGuitars),
    Instruments(image = R.drawable.electric_guitar, name = R.string.strings2, ElectricGuitars),
    Instruments(image = R.drawable.bass, name = R.string.strings3, Basses)
)
val drumsInstruments = listOf<Instruments>(
    Instruments(image = R.drawable.drums, name = R.string.drums1, AcousticDrums),
    Instruments(image = R.drawable.electric_drums, name = R.string.drums2, ElectronicDrums)
)
val keysInstruments = listOf<Instruments>(
    Instruments(image = R.drawable.piano, name = R.string.keys1, Pianos),
    Instruments(image = R.drawable.electric_piano, name = R.string.keys2, ElectronicPiano),
    Instruments(image = R.drawable.music_keyboard, name = R.string.keys3, Keyboards),
    Instruments(image = R.drawable.synth, name = R.string.keys4, Synths)
)