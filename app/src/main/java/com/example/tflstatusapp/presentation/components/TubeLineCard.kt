import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tflstatusapp.data.remote.TubeLineResponsesItem

@Composable
fun TubeLineCard(
    tubeLineResponsesItem: TubeLineResponsesItem
) {

    val title = tubeLineResponsesItem.name

    val hashMap = hashMapOf(
        "bakerloo" to "#894E24",
        "central" to "#DC241F",
        "circle" to "#FFCE00",
        "district" to "#007229",
        "hammersmith-city" to "#D799AF",
        "jubilee" to "#697278",
        "metropolitan" to "#751056",
        "northern" to "#000000",
        "piccadilly" to "#001AA8",
        "victoria" to "#01A0E2",
        "waterloo-city" to "#76D0BD"
    )

    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RectangleShape,
            elevation = CardDefaults.cardElevation(
                defaultElevation = 1.dp
            ),
            border = BorderStroke(0.5.dp, Color.LightGray)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.height(IntrinsicSize.Min)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(20.dp)
                        .background(
                            Color(
                                android.graphics.Color.parseColor(
                                    hashMap[tubeLineResponsesItem.id] ?: "#000000"
                                )
                            ),
                        )
                )
                Text(
                    text = title,
                    modifier = Modifier
                        .padding(top = 6.dp, bottom = 6.dp, start = 10.dp)
                        .focusable(true)
                        .semantics { contentDescription = title },
                    fontSize = 18.sp
                )
                Spacer(modifier = Modifier.weight(1f))

                val status = tubeLineResponsesItem.lineStatuses.joinToString("\n") {
                    it.statusSeverityDescription
                }

                Text(
                    text = status,
                    modifier = Modifier
                        .padding(top = 6.dp, bottom = 6.dp, start = 10.dp)
                        .focusable(true)
                        .semantics {
                            contentDescription = status
                        },
                    textAlign = TextAlign.End,
                    fontSize = 16.sp
                )
            }
        }
    }
}