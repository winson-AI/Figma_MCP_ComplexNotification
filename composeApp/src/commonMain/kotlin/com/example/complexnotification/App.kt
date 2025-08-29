package com.example.complexnotification

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import complexnotification.composeapp.generated.resources.*
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
	MaterialTheme {
		NotificationScreen()
	}
}

@Composable
private fun NotificationScreen() {
	Box(
		modifier = Modifier
			.fillMaxSize()
			.background(Color(0xFFF5CB58))
	) {
		// Header with time and status icons
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
				StatusIcon()
				StatusIcon(width = 15.dp, height = 8.dp)
				StatusIcon(width = 17.dp, height = 9.dp)
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
					UserIcon()
					NotificationIcon()
					CartIcon()
				}
				SearchField()
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
					fontStyle = FontStyle.Italic,
					fontWeight = FontWeight.SemiBold,
					color = Color(0xFFE95322)
				)
			}

			Spacer(Modifier.height(8.dp))
			Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
				BestSellerItem(Res.drawable.food_pizza)
				BestSellerItem(Res.drawable.food_burger)
				BestSellerItem(Res.drawable.food_pasta)
				BestSellerItem(Res.drawable.food_dessert)
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
				RecommendCard(Res.drawable.food_pizza)
				RecommendCard(Res.drawable.food_burger)
			}

			Spacer(Modifier.height(16.dp))
			PromoCard(Res.drawable.food_pizza)
		}

		// Bottom navigation
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
				BottomNavIcon(Res.drawable.ic_nav_home)
				BottomNavIcon(Res.drawable.ic_nav_heart)
				BottomNavIcon(Res.drawable.ic_nav_user)
				BottomNavIcon(Res.drawable.ic_nav_cart)
				BottomNavIcon(Res.drawable.ic_nav_settings)
			}
		}

		// Notification panel positioned on the right side
		NotificationPanel(
			modifier = Modifier
				.align(Alignment.TopEnd)
				.width(330.dp)
				.fillMaxHeight()
		)
	}
}

@Composable
private fun StatusIcon(width: Dp = 13.dp, height: Dp = 9.dp) {
	Box(
		modifier = Modifier
			.size(width = width, height = height)
			.clip(RoundedCornerShape(2.dp))
			.background(Color(0xFFF8F8F8))
	)
}

@Composable
private fun UserIcon() {
	Box(
		modifier = Modifier
			.size(26.dp)
			.clip(RoundedCornerShape(10.dp))
			.background(Color(0xFFF8F8F8))
	) {
		Image(
			painter = painterResource(Res.drawable.ic_user),
			contentDescription = "User",
			modifier = Modifier
				.size(15.dp)
				.align(Alignment.Center),
			contentScale = ContentScale.Fit
		)
	}
}

@Composable
private fun NotificationIcon() {
	Box(
		modifier = Modifier
			.size(26.dp)
			.clip(RoundedCornerShape(10.dp))
			.background(Color(0xFFF8F8F8))
	) {
		Image(
			painter = painterResource(Res.drawable.ic_notification),
			contentDescription = "Notification",
			modifier = Modifier
				.size(15.dp)
				.align(Alignment.Center),
			contentScale = ContentScale.Fit
		)
	}
}

@Composable
private fun CartIcon() {
	Box(
		modifier = Modifier
			.size(26.dp)
			.clip(RoundedCornerShape(10.dp))
			.background(Color(0xFFF8F8F8))
	) {
		Image(
			painter = painterResource(Res.drawable.ic_favorite),
			contentDescription = "Cart",
			modifier = Modifier
				.size(15.dp)
				.align(Alignment.Center),
			contentScale = ContentScale.Fit
		)
	}
}

@Composable
private fun SearchField() {
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
		Image(
			painter = painterResource(Res.drawable.ic_search),
			contentDescription = "Search Icon",
			modifier = Modifier.size(20.dp)
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
private fun BestSellerItem(image: DrawableResource) {
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
			Image(
				painter = painterResource(Res.drawable.ic_favorite),
				contentDescription = "Favorite",
				modifier = Modifier.size(14.dp)
			)
		}
	}
}

@Composable
private fun RecommendCard(image: DrawableResource) {
	Box(
		modifier = Modifier
			.size(width = 159.dp, height = 140.dp)
			.clip(RoundedCornerShape(20.dp))
	) {
		Image(
			painter = painterResource(image),
			contentDescription = null,
			modifier = Modifier.fillMaxSize(),
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
		Image(
			painter = painterResource(Res.drawable.ic_favorite),
			contentDescription = "Favorite",
			modifier = Modifier
				.align(Alignment.TopStart)
				.offset(x = 38.dp, y = 10.dp)
				.size(14.dp)
		)
	}
}

@Composable
private fun PromoCard(image: DrawableResource) {
	Box(
		modifier = Modifier
			.fillMaxWidth()
			.height(128.dp)
			.clip(RoundedCornerShape(20.dp))
			.background(Color(0xFFFE4A0C).copy(alpha = 0.15f))
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

		// Decorative circles
		Image(
			painter = painterResource(Res.drawable.ic_circle_decoration),
			contentDescription = null,
			modifier = Modifier
				.size(55.dp)
				.offset(x = 106.dp, y = (-37).dp)
				.align(Alignment.TopStart)
		)
		Image(
			painter = painterResource(Res.drawable.ic_circle_decoration),
			contentDescription = null,
			modifier = Modifier
				.size(46.dp)
				.offset(x = (-14).dp, y = 105.dp)
				.align(Alignment.TopStart)
		)

		Column(
			modifier = Modifier
				.align(Alignment.CenterStart)
				.padding(start = 14.dp),
			horizontalAlignment = Alignment.Start
		) {
			Text(
				text = "Experience our delicious new dish",
				fontSize = 16.sp,
				color = Color(0xFFF8F8F8),
				textAlign = TextAlign.Start
			)
			Text(
				text = "30% OFF",
				fontSize = 32.sp,
				fontWeight = FontWeight.Bold,
				color = Color(0xFFF8F8F8),
				textAlign = TextAlign.Start
			)
		}
	}
}

@Composable
private fun BottomNavIcon(icon: DrawableResource) {
	Image(
		painter = painterResource(icon),
		contentDescription = null,
		modifier = Modifier.size(24.dp)
	)
}

@Composable
private fun NotificationPanel(modifier: Modifier = Modifier) {
	Box(modifier = modifier) {
		// Background shape for the notification panel
		Box(
			modifier = Modifier
				.fillMaxSize()
				.background(
					color = Color.Black.copy(alpha = 0.7f),
					shape = RoundedCornerShape(
						topStart = 20.dp,
						bottomStart = 20.dp
					)
				)
		)

		// Notification content
		Column(
			modifier = Modifier
				.fillMaxSize()
				.padding(
					top = 87.dp, // Position from top to match design
					start = 24.dp,
					end = 24.dp
				)
		) {
			Row() {
				// Notification trigger icon (5th icon)
				Image(
					painter = painterResource(Res.drawable.ic_notification_trigger),
					contentDescription = "Notification Trigger",
					modifier = Modifier.size(22.dp)
				)
				// Title
				Text(
					text = "Notifications",
					fontSize = 24.sp,
					fontWeight = FontWeight.Bold,
					color = Color(0xFFF8F8F8),
					modifier = Modifier.padding(bottom = 20.dp)
				)
			}

			DividerLine()

			// Notification items with correct Figma icons
			NotificationItem(
				icon = Res.drawable.ic_notification, // Shopping cart icon for product added notification
				message = "We have added\na product you might like.",
				date = "03/12/24",
				time = "8:00"
			)
			DividerLine()

			NotificationItem(
				icon = Res.drawable.ic_cookware, // Cookware icon for promotion notification
				message = "One of your favorite is on promotion.",
				date = "03/12/24",
				time = "12:00"
			)
			DividerLine()

			NotificationItem(
				icon = Res.drawable.ic_heart, // Heart icon for delivered order
				message = "Your order has been delivered",
				date = "29/11/24",
				time = "16:00"
			)
			DividerLine()

			NotificationItem(
				icon = Res.drawable.ic_delivery_boy, // Delivery boy icon for delivery status
				message = "The delivery is\non his way",
				date = "29/11/24",
				time = "15:00"
			)
		}
	}
}

@Composable
private fun NotificationItem(
	icon: DrawableResource,
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
				.background(Color(0xFFF8F8F8)),
			contentAlignment = Alignment.Center
		) {
			Image(
				painter = painterResource(icon),
				contentDescription = null,
				modifier = Modifier.size(20.dp)
			)
		}
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