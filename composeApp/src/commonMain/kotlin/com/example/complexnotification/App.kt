package com.example.complexnotification

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import complexnotification.composeapp.generated.resources.Res
import complexnotification.composeapp.generated.resources.*
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
	MaterialTheme {
		NotificationsScreen()
	}
}

@Composable
private fun NotificationsScreen() {
	Box(
		modifier = Modifier
			.fillMaxSize()
			.background(Color(0xFFF5CB58))
	) {
		// Header (time + status icons placeholder)
		Row(
			modifier = Modifier
				.fillMaxWidth()
				.padding(top = 8.dp, start = 35.dp, end = 35.dp),
			horizontalArrangement = Arrangement.SpaceBetween,
			verticalAlignment = Alignment.CenterVertically
		) {
			Text(
				text = "16:04",
				fontSize = 13.sp,
				fontWeight = FontWeight.Medium,
				color = Color(0xFF391713)
			)
			Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
				StatusDot()
				StatusDot(width = 15.dp, height = 8.dp)
				StatusDot(width = 17.dp, height = 9.dp)
			}
		}

		Column(
			modifier = Modifier
				.fillMaxSize()
				.padding(horizontal = 24.dp)
				.padding(top = 54.dp)
		) {
			// Top action icons and search
			Row(
				modifier = Modifier.fillMaxWidth(),
				horizontalArrangement = Arrangement.SpaceBetween,
				verticalAlignment = Alignment.CenterVertically
			) {
				Row(horizontalArrangement = Arrangement.spacedBy(7.dp)) {
					SquareIconPlaceholder()
					SquareIconPlaceholder()
					SquareIconPlaceholder()
				}
				SearchFieldPlaceholder()
			}

			Spacer(Modifier.height(12.dp))
			Text(
				text = "Good Morning",
				fontSize = 24.sp,
				fontWeight = FontWeight.Black,
				color = Color(0xFFF8F8F8)
			)
			Text(
				text = "Rise and shine! It's breakfast time",
				fontSize = 13.sp,
				fontWeight = FontWeight.Medium,
				color = Color(0xFFE95322)
			)

			Spacer(Modifier.height(16.dp))
			DividerLine()

			Spacer(Modifier.height(12.dp))
			Row(
				modifier = Modifier.fillMaxWidth(),
				horizontalArrangement = Arrangement.SpaceBetween,
				verticalAlignment = Alignment.CenterVertically
			) {
				Text(
					text = "best seller",
					fontSize = 18.sp,
					fontWeight = FontWeight.SemiBold,
					color = Color(0xFF391713)
				)
				Text(
					text = "View All",
					fontSize = 12.sp,
					fontStyle = androidx.compose.ui.text.font.FontStyle.Italic,
					fontWeight = FontWeight.SemiBold,
					color = Color(0xFFE95322)
				)
			}

			Spacer(Modifier.height(8.dp))
			Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
				BestSellerImage(Res.drawable.best_seller_1)
				BestSellerImage(Res.drawable.best_seller_2)
				BestSellerImage(Res.drawable.best_seller_3)
				BestSellerImage(Res.drawable.best_seller_4)
			}

			Spacer(Modifier.height(16.dp))
			DividerLine()

			Spacer(Modifier.height(16.dp))
			Text(
				text = "recommend",
				fontSize = 18.sp,
				fontWeight = FontWeight.SemiBold,
				color = Color(0xFF391713)
			)

			Spacer(Modifier.height(12.dp))
			Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
				RecommendCardImage(Res.drawable.recommend_card_left)
				RecommendCardImage(Res.drawable.recommend_card_right)
			}

			Spacer(Modifier.height(16.dp))
			PromoCardWithImage(Res.drawable.promo_pizza)
		}

		// Bottom navigation placeholder bar
		Box(
			modifier = Modifier
				.align(Alignment.BottomCenter)
				.fillMaxWidth()
				.height(61.dp)
				.clip(RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
				.background(Color(0xFFE95322))
		) {
			Row(
				modifier = Modifier
					.fillMaxWidth()
					.padding(horizontal = 32.dp),
				horizontalArrangement = Arrangement.SpaceBetween,
				verticalAlignment = Alignment.CenterVertically
			) {
				FooterDot()
				FooterDot()
				FooterDot()
				FooterDot()
			}
		}

		// Overlay: Component 53 - Notifications (most important)
		NotificationsComponent53(
			modifier = Modifier
				.align(Alignment.TopStart)
				.padding(top = 64.dp) // positions under status/search area
				.padding(start = 66.dp)
		)
	}
}

@Composable
private fun StatusDot(width: Dp = 13.dp, height: Dp = 9.dp) {
	Box(
		modifier = Modifier
			.size(width = width, height = height)
			.clip(RoundedCornerShape(2.dp))
			.background(Color(0xFFF8F8F8))
	)
}

@Composable
private fun SquareIconPlaceholder() {
	Box(
		modifier = Modifier
			.size(26.dp)
			.clip(RoundedCornerShape(10.dp))
			.background(Color(0xFFF8F8F8))
	)
}

@Composable
private fun SearchFieldPlaceholder() {
	Row(
		modifier = Modifier
			.clip(RoundedCornerShape(30.dp))
			.background(Color.White)
			.padding(horizontal = 12.dp, vertical = 6.dp),
		verticalAlignment = Alignment.CenterVertically
	) {
		Text(
			text = "Search",
			fontSize = 12.sp,
			fontWeight = FontWeight.Light,
			color = Color(0xFF676767)
		)
		Spacer(Modifier.weight(1f))
		Box(
			modifier = Modifier
				.size(20.dp)
				.clip(CircleShape)
				.background(Color(0xFFE95322))
		)
	}
}

@Composable
private fun DividerLine() {
	Box(
		modifier = Modifier
			.fillMaxWidth()
			.height(1.dp)
			.background(Color(0xFFFFDECF))
	)
}

@Composable
private fun BestSellerCardPlaceholder() {
	Column(horizontalAlignment = Alignment.CenterHorizontally) {
		Box(
			modifier = Modifier
				.size(width = 72.dp, height = 108.dp)
				.clip(RoundedCornerShape(20.dp))
				.background(Color(0xFFF3E9B5))
		)
		Spacer(Modifier.height(6.dp))
		Row(
			verticalAlignment = Alignment.CenterVertically
		) {
			Box(
				modifier = Modifier
					.clip(RoundedCornerShape(30.dp))
					.background(Color.White)
					.padding(horizontal = 8.dp, vertical = 2.dp)
			) {
				Text(
					text = "5.0",
					fontSize = 12.sp,
					color = Color(0xFF391713)
				)
			}
			Spacer(Modifier.width(6.dp))
			Box(
				modifier = Modifier
					.size(14.dp)
					.clip(CircleShape)
					.background(Color(0xFFF8F8F8))
			)
		}
	}
}

@Composable
private fun BestSellerImage(image: DrawableResource) {
	Column(horizontalAlignment = Alignment.CenterHorizontally) {
		Image(
			painter = painterResource(image),
			contentDescription = null,
			modifier = Modifier
				.size(width = 72.dp, height = 108.dp)
				.clip(RoundedCornerShape(20.dp)),
			contentScale = ContentScale.Crop
		)
		Spacer(Modifier.height(6.dp))
		Row(
			verticalAlignment = Alignment.CenterVertically
		) {
			Box(
				modifier = Modifier
					.clip(RoundedCornerShape(30.dp))
					.background(Color.White)
					.padding(horizontal = 8.dp, vertical = 2.dp)
			) {
				Text(
					text = "5.0",
					fontSize = 12.sp,
					color = Color(0xFF391713)
				)
			}
			Spacer(Modifier.width(6.dp))
			Box(
				modifier = Modifier
					.size(14.dp)
					.clip(CircleShape)
					.background(Color(0xFFF8F8F8))
			)
		}
	}
}

@Composable
private fun RecommendCardPlaceholder() {
	Box(
		modifier = Modifier
			.size(width = 159.dp, height = 140.dp)
			.clip(RoundedCornerShape(20.dp))
			.background(Color(0xFFECECEC))
	) {
		Box(
			modifier = Modifier
				.align(Alignment.TopStart)
				.offset(x = 12.dp, y = 10.dp)
				.clip(RoundedCornerShape(30.dp))
				.background(Color.White)
				.padding(horizontal = 8.dp, vertical = 2.dp)
		) {
			Text(
				text = "5.0",
				fontSize = 12.sp,
				color = Color(0xFF391713)
			)
		}
		Box(
			modifier = Modifier
				.align(Alignment.TopStart)
				.offset(x = 38.dp, y = 10.dp)
				.size(14.dp)
				.clip(CircleShape)
				.background(Color(0xFFF8F8F8))
		)
	}
}

@Composable
private fun RecommendCardImage(image: DrawableResource) {
	Box(
		modifier = Modifier
			.size(width = 159.dp, height = 140.dp)
			.clip(RoundedCornerShape(20.dp))
	) {
		Image(
			painter = painterResource(image),
			contentDescription = null,
			modifier = Modifier.matchParentSize(),
			contentScale = ContentScale.Crop
		)
		Box(
			modifier = Modifier
				.align(Alignment.TopStart)
				.offset(x = 12.dp, y = 10.dp)
				.clip(RoundedCornerShape(30.dp))
				.background(Color.White)
				.padding(horizontal = 8.dp, vertical = 2.dp)
		) {
			Text(
				text = "5.0",
				fontSize = 12.sp,
				color = Color(0xFF391713)
			)
		}
		Box(
			modifier = Modifier
				.align(Alignment.TopStart)
				.offset(x = 38.dp, y = 10.dp)
				.size(14.dp)
				.clip(CircleShape)
				.background(Color(0xFFF8F8F8))
		)
	}
}

@Composable
private fun PromoCardPlaceholder() {
	Box(
		modifier = Modifier
			.fillMaxWidth()
			.height(128.dp)
			.clip(RoundedCornerShape(20.dp))
			.background(Color(0xFFFE4A0C).copy(alpha = 0.15f))
	) {
		// Decorative circles to mimic strokes
		Box(
			modifier = Modifier
				.size(55.dp)
				.offset(x = 106.dp, y = (-37).dp)
				.clip(CircleShape)
				.border(2.dp, Color(0xFFF5CB58), CircleShape)
		)
		Box(
			modifier = Modifier
				.size(46.dp)
				.offset(x = (-14).dp, y = 105.dp)
				.clip(CircleShape)
				.border(2.dp, Color(0xFFF5CB58), CircleShape)
		)
		Column(
			modifier = Modifier
				.align(Alignment.CenterStart)
				.padding(start = 14.dp),
			horizontalAlignment = Alignment.CenterHorizontally
		) {
			Text(
				text = "Experience our delicious new dish",
				fontSize = 16.sp,
				color = Color(0xFFF8F8F8),
				textAlign = TextAlign.Center
			)
			Text(
				text = "30% OFF",
				fontSize = 32.sp,
				fontWeight = FontWeight.Bold,
				color = Color(0xFFF8F8F8),
				textAlign = TextAlign.Center
			)
		}
	}
}

@Composable
private fun PromoCardWithImage(image: DrawableResource) {
	Box(
		modifier = Modifier
			.fillMaxWidth()
			.height(128.dp)
			.clip(RoundedCornerShape(20.dp))
			.background(Color.Transparent)
	) {
		// Right side promo image
		Image(
			painter = painterResource(image),
			contentDescription = null,
			modifier = Modifier
				.align(Alignment.TopEnd)
				.height(141.dp)
				.clip(RoundedCornerShape(topEnd = 20.dp, bottomEnd = 20.dp)),
			contentScale = ContentScale.Crop
		)
		// Decorative circles to mimic strokes
		Box(
			modifier = Modifier
				.size(55.dp)
				.offset(x = 106.dp, y = (-37).dp)
				.clip(CircleShape)
				.border(2.dp, Color(0xFFF5CB58), CircleShape)
		)
		Box(
			modifier = Modifier
				.size(46.dp)
				.offset(x = (-14).dp, y = 105.dp)
				.clip(CircleShape)
				.border(2.dp, Color(0xFFF5CB58), CircleShape)
		)
		Column(
			modifier = Modifier
				.align(Alignment.CenterStart)
				.padding(start = 14.dp),
			horizontalAlignment = Alignment.CenterHorizontally
		) {
			Text(
				text = "Experience our delicious new dish",
				fontSize = 16.sp,
				color = Color(0xFFF8F8F8),
				textAlign = TextAlign.Center
			)
			Text(
				text = "30% OFF",
				fontSize = 32.sp,
				fontWeight = FontWeight.Bold,
				color = Color(0xFFF8F8F8),
				textAlign = TextAlign.Center
			)
		}
	}
}

@Composable
private fun FooterDot() {
	Box(
		modifier = Modifier
			.size(width = 16.dp, height = 6.dp)
			.clip(RoundedCornerShape(12.dp))
			.background(Color(0xFFF3E9B5))
	)
}

@Composable
private fun NotificationsComponent53(modifier: Modifier = Modifier) {
	// Mimic the slide "Menu Slide / Notifications" (Component 53) layout
	Column(
		modifier = modifier
			.width(330.dp)
	) {
		Text(
			text = "Notifications",
			fontSize = 24.sp,
			fontWeight = FontWeight.Bold,
			color = Color(0xFFF8F8F8)
		)

		Spacer(Modifier.height(20.dp))

		NotificationRow(
			iconBg = Color(0xFFF8F8F8),
			message = "We have added\na product you might like.",
			date = "03/12/24",
			time = "8:00"
		)
		DividerLine()

		NotificationRow(
			iconBg = Color(0xFFF8F8F8),
			message = "One of your favorite is on promotion.",
			date = "03/12/24",
			time = "12:00"
		)
		DividerLine()

		NotificationRow(
			iconBg = Color(0xFFF8F8F8),
			message = "Your order has been delivered",
			date = "29/11/24",
			time = "16:00"
		)
		DividerLine()

		NotificationRow(
			iconBg = Color(0xFFF8F8F8),
			message = "The delivery is\non his way",
			date = "29/11/24",
			time = "15:00"
		)
	}
}

@Composable
private fun NotificationRow(
	iconBg: Color,
	message: String,
	date: String,
	time: String
) {
	Row(
		modifier = Modifier
			.fillMaxWidth()
			.padding(vertical = 12.dp),
		verticalAlignment = Alignment.CenterVertically
	) {
		Box(
			modifier = Modifier
				.size(40.dp)
				.clip(RoundedCornerShape(13.dp))
				.background(iconBg)
		)
		Spacer(Modifier.width(16.dp))
		Text(
			text = message,
			fontSize = 15.sp,
			fontWeight = FontWeight.Medium,
			color = Color(0xFFFFFFFF),
			modifier = Modifier.weight(1f)
		)
		Column(horizontalAlignment = Alignment.End) {
			Text(text = date, fontSize = 13.sp, fontWeight = FontWeight.Medium, color = Color(0xFFFFFFFF))
			Text(text = time, fontSize = 13.sp, fontWeight = FontWeight.Medium, color = Color(0xFFFFFFFF))
		}
	}
}