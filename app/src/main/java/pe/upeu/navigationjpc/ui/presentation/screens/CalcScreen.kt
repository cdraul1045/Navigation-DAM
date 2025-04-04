package pe.upeu.navigationjpc.ui.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import pe.upeu.navigationjpc.ui.theme.Purple200
import pe.upeu.navigationjpc.ui.theme.textColor
import kotlin.math.PI
import kotlin.math.pow
import kotlin.math.sqrt

// ... (isNumeric, calculatePower, calculateSquareRoot, calculateReciprocal functions remain the same)

@Composable
fun CalcScreen(
    onNavigateToHome: () -> Unit // Add navigation parameter
) {
    Column(modifier = Modifier.fillMaxSize()) {
        var op by remember { mutableStateOf("") }
        var isNewOp by remember { mutableStateOf(true) }
        var oldTextState: String by remember { mutableStateOf("") }
        var textState: String by remember { mutableStateOf("0") }

        CalculatorTextField(
            textState = textState,
            modifier = Modifier.height(100.dp),
            onValueChange = { textState = it }
        )

        Column(modifier = Modifier.weight(1f)) {
            val listA = listOf("AC", "√", "1/x", "π")
            val listB = listOf("7", "8", "9", "*")
            val listC = listOf("4", "5", "6", "+")
            val listD = listOf("1", "2", "3", "-")
            val listE = listOf("0", "^", "=")
            val listaCompleta = listOf(listA, listB, listC, listD, listE)

            listaCompleta.forEach {
                CalculatorFirstRow(
                    isNewOp = isNewOp,
                    textState = textState,
                    onValueChange = { textState = it },
                    onIsNewOpChange = { isNewOp = it },
                    onOpChange = { op = it },
                    onOldValueChange = { oldTextState = it },
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth(),
                    op = op,
                    oldTextState = oldTextState,
                    data = it
                )
            }
        }
    }
}

@Composable
fun ButtonX(
    modifier: Modifier,
    valuex: String,
    onValueChange: (String) -> Unit,
    onIsNewOpChange: (Boolean) -> Unit,
    textState: String,
    isNewOp : Boolean,
    onOpChange: (String) -> Unit,
    onOldValueChange: (String) -> Unit,
    oldTextState: String,
    op:String
) {
    Column(modifier = modifier.wrapContentSize(Alignment.Center)) {
        Box(
            modifier = modifier
                .weight(1f)
                .background(Color(0xFF8BC34A))
                .border(width = .5.dp, Color(0xFF2C2F32))
                .clickable(
                    enabled = true,
                    onClick = {
                        if (isNumeric(valuex)) {
                            var valor = textState
                            if (isNewOp) {
                                valor = ""
                                onValueChange.invoke(valor)
                            }
                            onIsNewOpChange.invoke(false)
                            valor += valuex
                            onValueChange.invoke(valor)
                        }
                        if (valuex.equals("+") || valuex.equals("-") || valuex.equals("*") || valuex.equals(
                                "/"
                            ) || valuex.equals("%")
                        ) {
                            onOpChange.invoke(valuex)
                            onOldValueChange.invoke(textState)
                            onIsNewOpChange.invoke(true)
                        }
                        if (valuex.equals("AC")) {
                            onValueChange.invoke("0")
                            onIsNewOpChange.invoke(true)
                        }
                        if (valuex.equals(".")) {
                            var dot = textState
                            if (isNewOp) {
                                dot = ""
                                onValueChange.invoke(dot)
                            }
                            onIsNewOpChange.invoke(false)
                            if (!dot.contains(".")) {
                                dot += "."
                                onValueChange.invoke(dot)
                            }
                        }
                        // Added scientific function operations
                        when (valuex) {
                            "^" -> {
                                if (textState.isNotEmpty() && isNumeric(textState)) {
                                    onOldValueChange.invoke(textState) // Guardar el número actual antes de elevar
                                    onOpChange.invoke("^") // Guardar la operación
                                    onIsNewOpChange.invoke(true) // Indicar que la siguiente entrada es un nuevo número
                                }
                            }

                            "√" -> {
                                val result =
                                    calculateSquareRoot(textState.toDouble())
                                onValueChange.invoke(result.toString())
                                onIsNewOpChange.invoke(true)
                            }
                            "1/x" -> {
                                val result =
                                    calculateReciprocal(textState.toDouble())
                                onValueChange.invoke(result.toString())
                                onIsNewOpChange.invoke(true)
                            }
                            "π" -> {
                                onValueChange.invoke(PI.toString())
                                onIsNewOpChange.invoke(true)
                            }
                            "=" -> {
                                if (oldTextState.isNotEmpty() && textState.isNotEmpty() && isNumeric(
                                        oldTextState
                                    ) && isNumeric(textState)
                                ) {
                                    var finalNumber = 0.0
                                    when (op) {
                                        "*" -> finalNumber = oldTextState.toDouble() * textState.toDouble()
                                        "/" -> finalNumber = oldTextState.toDouble() / textState.toDouble()
                                        "+" -> finalNumber = oldTextState.toDouble() + textState.toDouble()
                                        "-" -> finalNumber = oldTextState.toDouble() - textState.toDouble()
                                        "^" -> finalNumber = calculatePower(
                                            oldTextState.toDouble(),
                                            textState.toDouble()
                                        )
                                    }
                                    onValueChange.invoke(finalNumber.toString())
                                    onIsNewOpChange.invoke(true)
                                }
                            }
                        }
                    }
                )
        ) {
            Text(
                text = valuex,
                style = TextStyle(
                    fontSize = 24.sp,
                    textAlign = TextAlign.End,
                    color = textColor,
                    fontWeight = FontWeight.Bold
                ),
                modifier = Modifier
                    .fillMaxSize()
                    .wrapContentSize(Alignment.Center)
            )
        }
    }
}

@Composable
fun CalculatorTextField(
    textState: String,
    modifier: Modifier,
    onValueChange: (String) -> Unit,
) {
    Column(
        modifier = modifier
            .background(Purple200)
            .wrapContentSize(Alignment.BottomEnd)
            .fillMaxSize()
    ) {
        TextField(
            value = textState,
            onValueChange = onValueChange,
            modifier = Modifier
                .weight(1f)
                .wrapContentSize(Alignment.BottomEnd)
                .fillMaxSize(),
            textStyle = TextStyle(fontSize = 36.sp, textAlign = TextAlign.End, color = textColor),
            maxLines = 2,
            readOnly = true
        )
    }
}

@Composable
fun CalculatorFirstRow(
    textState: String,
    isNewOp: Boolean,
    onValueChange: (String) -> Unit,
    onIsNewOpChange: (Boolean) -> Unit,
    onOpChange: (String) -> Unit,
    onOldValueChange: (String) -> Unit,
    modifier: Modifier,
    op: String,
    oldTextState: String,
    data: List<String>
) {
    Row(modifier = modifier.fillMaxSize()) {
        var listB = data
        listB.forEach {
            ButtonX(
                modifier = modifier,
                valuex = it,
                onValueChange = onValueChange,
                onIsNewOpChange = onIsNewOpChange,
                textState = textState, isNewOp = isNewOp,
                onOpChange = onOpChange,
                onOldValueChange = onOldValueChange,
                op = op,
                oldTextState = oldTextState
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewCalculatorScreen() {
    MaterialTheme {
        CalcScreen(onNavigateToHome = {}) // Provide a dummy navigation function for preview
    }
}

fun isNumeric(toCheck: String): Boolean {
    val regex = "-?[0-9]+(\\.[0-9]+)?".toRegex()
    return toCheck.matches(regex)
}

// Scientific calculation functions
fun calculatePower(base: Double, exponent: Double): Double {
    return base.pow(exponent)
}

fun calculateSquareRoot(value: Double): Double {
    return sqrt(value)
}

fun calculateReciprocal(value: Double): Double {
    return if (value != 0.0) 1 / value else Double.NaN
}