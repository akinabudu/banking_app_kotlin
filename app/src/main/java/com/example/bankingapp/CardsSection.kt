package com.example.bankingapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bankingapp.data.Card
import com.example.bankingapp.ui.theme.BlueEnd
import com.example.bankingapp.ui.theme.BlueStart
import com.example.bankingapp.ui.theme.GreenEnd
import com.example.bankingapp.ui.theme.GreenStart
import com.example.bankingapp.ui.theme.OrangeEnd
import com.example.bankingapp.ui.theme.OrangeStart
import com.example.bankingapp.ui.theme.PurpleEnd
import com.example.bankingapp.ui.theme.PurpleStart

val cards:List<Card> = listOf(
    Card(
        cardType = "VISA",
        cardNumber = "3344 4322 5566 8875",
        cardName = "Business",
        balance = 46.47,
        color = getGradient(PurpleStart, PurpleEnd),
    ),
    Card(
        cardType = "MASTERCARD",
        cardNumber = "7766 8765 2334 0982",
        cardName = "Savings",
        balance = 26.47,
        color = getGradient(BlueStart, BlueEnd),
    ),
    Card(
        cardType = "VISA",
        cardNumber = "2134 9098 3563 1239",
        cardName = "School",
        balance = 16.47,
        color = getGradient(OrangeStart, OrangeEnd),
    ),
    Card(
        cardType = "MASTERCARD",
        cardNumber = "5554 4354 5546 2443",
        cardName = "Trips",
        balance = 59.47,
        color = getGradient(GreenStart, GreenEnd),
    ),

)



@Preview
@Composable
fun CardsSection(){
    LazyRow {
        items(cards.size) {index ->
            CardItem(index)
        }
    }
}

@Composable
fun CardItem(index:Int){
    val card = cards[index]
    var lastItemPaddingEnd = 0.dp
    if (index == cards.size - 1 ){
        lastItemPaddingEnd = 16.dp
    }
    var image = painterResource(id = R.drawable.visa)
    if(card.cardType == "MASTERCARD"){
        image = painterResource(id = R.drawable.mastercard)
    }
    Box(modifier = Modifier.padding(start = 16.dp, end= lastItemPaddingEnd)){
        Column(modifier = Modifier
            .clip(RoundedCornerShape(25.dp))
            .background(card.color)
            .height(160.dp)
            .width(250.dp)
            .clickable { }
            .padding(vertical = 12.dp, horizontal = 16.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Image(painter = image, contentDescription = card.cardName, modifier = Modifier.width(60.dp) )
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = card.cardName, color = Color.White, fontSize = 17.sp, fontWeight = FontWeight.Bold)
            Text(text = "$ ${card.balance }", color = Color.White, fontSize = 22.sp, fontWeight = FontWeight.Bold)
            Text(text = card.cardNumber, color = Color.White, fontSize = 18.sp, fontWeight = FontWeight.Bold)

        }
    }
}