package com.example.books;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class QueryUtils {
    private static final String SAMPLE_JSON_RESPONSE = "{\n" +
            "  \"kind\": \"books#volumes\",\n" +
            "  \"totalItems\": 1766,\n" +
            "  \"items\": [\n" +
            "    {\n" +
            "      \"kind\": \"books#volume\",\n" +
            "      \"id\": \"aYpoDwAAQBAJ\",\n" +
            "      \"etag\": \"diRXV4Yu/RA\",\n" +
            "      \"selfLink\": \"https://www.googleapis.com/books/v1/volumes/aYpoDwAAQBAJ\",\n" +
            "      \"volumeInfo\": {\n" +
            "        \"title\": \"Professional Android\",\n" +
            "        \"authors\": [\n" +
            "          \"Reto Meier\",\n" +
            "          \"Ian Lake\"\n" +
            "        ],\n" +
            "        \"publisher\": \"John Wiley & Sons\",\n" +
            "        \"publishedDate\": \"2018-09-25\",\n" +
            "        \"description\": \"The comprehensive developer guide to the latest Android features and capabilities Professional Android, 4th Edition shows developers how to leverage the latest features of Android to create robust and compelling mobile apps. This hands-on approach provides in-depth coverage through a series of projects, each introducing a new Android platform feature and highlighting the techniques and best practices that exploit its utmost functionality. The exercises begin simply, and gradually build into advanced Android development. Clear, concise examples show you how to quickly construct real-world mobile applications. This book is your guide to smart, efficient, effective Android development. Learn the best practices that get more out of Android Understand the anatomy, lifecycle, and UI metaphor of Android apps Design for all mobile platforms, including tablets Utilize both the Android framework and Google Play services\",\n" +
            "        \"industryIdentifiers\": [\n" +
            "          {\n" +
            "            \"type\": \"ISBN_13\",\n" +
            "            \"identifier\": \"9781118949528\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"type\": \"ISBN_10\",\n" +
            "            \"identifier\": \"1118949528\"\n" +
            "          }\n" +
            "        ],\n" +
            "        \"readingModes\": {\n" +
            "          \"text\": false,\n" +
            "          \"image\": true\n" +
            "        },\n" +
            "        \"pageCount\": 928,\n" +
            "        \"printType\": \"BOOK\",\n" +
            "        \"categories\": [\n" +
            "          \"Computers\"\n" +
            "        ],\n" +
            "        \"maturityRating\": \"NOT_MATURE\",\n" +
            "        \"allowAnonLogging\": false,\n" +
            "        \"contentVersion\": \"0.4.0.0.preview.1\",\n" +
            "        \"panelizationSummary\": {\n" +
            "          \"containsEpubBubbles\": false,\n" +
            "          \"containsImageBubbles\": false\n" +
            "        },\n" +
            "        \"imageLinks\": {\n" +
            "          \"smallThumbnail\": \"http://books.google.com/books/content?id=aYpoDwAAQBAJ&printsec=frontcover&img=1&zoom=5&edge=curl&source=gbs_api\",\n" +
            "          \"thumbnail\": \"http://books.google.com/books/content?id=aYpoDwAAQBAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api\"\n" +
            "        },\n" +
            "        \"language\": \"en\",\n" +
            "        \"previewLink\": \"http://books.google.co.in/books?id=aYpoDwAAQBAJ&printsec=frontcover&dq=android&hl=&cd=1&source=gbs_api\",\n" +
            "        \"infoLink\": \"http://books.google.co.in/books?id=aYpoDwAAQBAJ&dq=android&hl=&source=gbs_api\",\n" +
            "        \"canonicalVolumeLink\": \"https://books.google.com/books/about/Professional_Android.html?hl=&id=aYpoDwAAQBAJ\"\n" +
            "      },\n" +
            "      \"saleInfo\": {\n" +
            "        \"country\": \"IN\",\n" +
            "        \"saleability\": \"NOT_FOR_SALE\",\n" +
            "        \"isEbook\": false\n" +
            "      },\n" +
            "      \"accessInfo\": {\n" +
            "        \"country\": \"IN\",\n" +
            "        \"viewability\": \"PARTIAL\",\n" +
            "        \"embeddable\": true,\n" +
            "        \"publicDomain\": false,\n" +
            "        \"textToSpeechPermission\": \"ALLOWED\",\n" +
            "        \"epub\": {\n" +
            "          \"isAvailable\": false\n" +
            "        },\n" +
            "        \"pdf\": {\n" +
            "          \"isAvailable\": false\n" +
            "        },\n" +
            "        \"webReaderLink\": \"http://play.google.com/books/reader?id=aYpoDwAAQBAJ&hl=&printsec=frontcover&source=gbs_api\",\n" +
            "        \"accessViewStatus\": \"SAMPLE\",\n" +
            "        \"quoteSharingAllowed\": false\n" +
            "      },\n" +
            "      \"searchInfo\": {\n" +
            "        \"textSnippet\": \"Clear, concise examples show you how to quickly construct real-world mobile applications. This book is your guide to smart, efficient, effective Android development.\"\n" +
            "      }\n" +
            "    },\n" +
            "    {\n" +
            "      \"kind\": \"books#volume\",\n" +
            "      \"id\": \"oMYQz4_BW48C\",\n" +
            "      \"etag\": \"pNaViFleNyA\",\n" +
            "      \"selfLink\": \"https://www.googleapis.com/books/v1/volumes/oMYQz4_BW48C\",\n" +
            "      \"volumeInfo\": {\n" +
            "        \"title\": \"Learning Android\",\n" +
            "        \"authors\": [\n" +
            "          \"Marko Gargenta\"\n" +
            "        ],\n" +
            "        \"publisher\": \"\\\"O'Reilly Media, Inc.\\\"\",\n" +
            "        \"publishedDate\": \"2011-03-10\",\n" +
            "        \"description\": \"Want to build apps for Android devices? This book is the perfect way to master the fundamentals. Written by an expert who's taught this mobile platform to hundreds of developers in large organizations, this gentle introduction shows experienced object-oriented programmers how to use Android’s basic building blocks to create user interfaces, store data, connect to the network, and more. You'll build a Twitter-like application throughout the course of this book, adding new features with each chapter. Along the way, you'll also create your own toolbox of code patterns to help you program any type of Android application with ease. Get an overview of the Android platform and discover how it fits into the mobile ecosystem Learn about the Android stack, including its application framework, and the structure and distribution of application packages (APK) Set up your Android development environment and get started with simple programs Use Android’s building blocks—Activities, Intents, Services, Content Providers, and Broadcast Receivers Learn how to build basic Android user interfaces and organize UI elements in Views and Layouts Build a service that uses a background process to update data in your application Get an introduction to Android Interface Definition Language (AIDL) and the Native Development Kit (NDK)\",\n" +
            "        \"industryIdentifiers\": [\n" +
            "          {\n" +
            "            \"type\": \"ISBN_13\",\n" +
            "            \"identifier\": \"9781449307240\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"type\": \"ISBN_10\",\n" +
            "            \"identifier\": \"1449307248\"\n" +
            "          }\n" +
            "        ],\n" +
            "        \"readingModes\": {\n" +
            "          \"text\": true,\n" +
            "          \"image\": true\n" +
            "        },\n" +
            "        \"pageCount\": 270,\n" +
            "        \"printType\": \"BOOK\",\n" +
            "        \"categories\": [\n" +
            "          \"Computers\"\n" +
            "        ],\n" +
            "        \"averageRating\": 4,\n" +
            "        \"ratingsCount\": 7,\n" +
            "        \"maturityRating\": \"NOT_MATURE\",\n" +
            "        \"allowAnonLogging\": true,\n" +
            "        \"contentVersion\": \"0.3.2.0.preview.3\",\n" +
            "        \"imageLinks\": {\n" +
            "          \"smallThumbnail\": \"http://books.google.com/books/content?id=oMYQz4_BW48C&printsec=frontcover&img=1&zoom=5&edge=curl&source=gbs_api\",\n" +
            "          \"thumbnail\": \"http://books.google.com/books/content?id=oMYQz4_BW48C&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api\"\n" +
            "        },\n" +
            "        \"language\": \"en\",\n" +
            "        \"previewLink\": \"http://books.google.co.in/books?id=oMYQz4_BW48C&printsec=frontcover&dq=android&hl=&cd=2&source=gbs_api\",\n" +
            "        \"infoLink\": \"http://books.google.co.in/books?id=oMYQz4_BW48C&dq=android&hl=&source=gbs_api\",\n" +
            "        \"canonicalVolumeLink\": \"https://books.google.com/books/about/Learning_Android.html?hl=&id=oMYQz4_BW48C\"\n" +
            "      },\n" +
            "      \"saleInfo\": {\n" +
            "        \"country\": \"IN\",\n" +
            "        \"saleability\": \"NOT_FOR_SALE\",\n" +
            "        \"isEbook\": false\n" +
            "      },\n" +
            "      \"accessInfo\": {\n" +
            "        \"country\": \"IN\",\n" +
            "        \"viewability\": \"PARTIAL\",\n" +
            "        \"embeddable\": true,\n" +
            "        \"publicDomain\": false,\n" +
            "        \"textToSpeechPermission\": \"ALLOWED\",\n" +
            "        \"epub\": {\n" +
            "          \"isAvailable\": true\n" +
            "        },\n" +
            "        \"pdf\": {\n" +
            "          \"isAvailable\": true\n" +
            "        },\n" +
            "        \"webReaderLink\": \"http://play.google.com/books/reader?id=oMYQz4_BW48C&hl=&printsec=frontcover&source=gbs_api\",\n" +
            "        \"accessViewStatus\": \"SAMPLE\",\n" +
            "        \"quoteSharingAllowed\": false\n" +
            "      },\n" +
            "      \"searchInfo\": {\n" +
            "        \"textSnippet\": \"Want to build apps for Android devices? This book is the perfect way to master the fundamentals.\"\n" +
            "      }\n" +
            "    },\n" +
            "    {\n" +
            "      \"kind\": \"books#volume\",\n" +
            "      \"id\": \"JGH0DwAAQBAJ\",\n" +
            "      \"etag\": \"9qpA1vhnkOA\",\n" +
            "      \"selfLink\": \"https://www.googleapis.com/books/v1/volumes/JGH0DwAAQBAJ\",\n" +
            "      \"volumeInfo\": {\n" +
            "        \"title\": \"Android For Dummies\",\n" +
            "        \"authors\": [\n" +
            "          \"Dan Gookin\"\n" +
            "        ],\n" +
            "        \"publisher\": \"John Wiley & Sons\",\n" +
            "        \"publishedDate\": \"2020-09-09\",\n" +
            "        \"description\": \"Your comprehensive (and very friendly!) reference guide to Android phones and tablets You’re used to hearing it said that the phone in your pocket or tablet by your bed has more computing power than the entire Apollo 11 space program in the 1960s (or something similarly impressive)—and this is no less true for Android devices than any other. Sounds great—but what does that actually mean you can do with them? The new edition of Android For Dummies reveals all for new and experienced users alike, making it easy to get the most out of the awesome computing power of Android smartphone and tablet devices—from communications and pictures and videos to the wonderful world of 2.8+ million Google apps! Cutting through the jargon, bestselling tech author Dan Gookin puts you in touch with all the Android features you’ll need to know (and many more you’ll be pleased to discover!), from setup and configuration to the major features, such as text, email, internet, maps, navigation, camera, and video, as well as synching with your home computer. In addition to getting familiar with these and the latest Android 10 operating system (OS)—in both Google Pixel and Samsung versions—you’ll become an expert on the best ways to share your thoughts, videos, and pictures on social media, navigate with Android Auto when driving, and maintain your files so they’re orderly and easy to find. Explore Android devices, from physical functions to software and online features Communicate via email, social media, Google Duo video calls, and more Tweak your privacy settings to keep your information secure Use Android Auto when driving and see in the dark with Night Light and Dark Mode Androids may be able to land a spacecraft on the Moon (yet) but there’s a whole universe waiting right there in the device at your fingertips—and this book is the perfect place to begin to explore!\",\n" +
            "        \"industryIdentifiers\": [\n" +
            "          {\n" +
            "            \"type\": \"ISBN_13\",\n" +
            "            \"identifier\": \"9781119711353\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"type\": \"ISBN_10\",\n" +
            "            \"identifier\": \"1119711355\"\n" +
            "          }\n" +
            "        ],\n" +
            "        \"readingModes\": {\n" +
            "          \"text\": false,\n" +
            "          \"image\": true\n" +
            "        },\n" +
            "        \"pageCount\": 368,\n" +
            "        \"printType\": \"BOOK\",\n" +
            "        \"categories\": [\n" +
            "          \"Computers\"\n" +
            "        ],\n" +
            "        \"maturityRating\": \"NOT_MATURE\",\n" +
            "        \"allowAnonLogging\": false,\n" +
            "        \"contentVersion\": \"0.3.0.0.preview.1\",\n" +
            "        \"panelizationSummary\": {\n" +
            "          \"containsEpubBubbles\": false,\n" +
            "          \"containsImageBubbles\": false\n" +
            "        },\n" +
            "        \"imageLinks\": {\n" +
            "          \"smallThumbnail\": \"http://books.google.com/books/content?id=JGH0DwAAQBAJ&printsec=frontcover&img=1&zoom=5&edge=curl&source=gbs_api\",\n" +
            "          \"thumbnail\": \"http://books.google.com/books/content?id=JGH0DwAAQBAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api\"\n" +
            "        },\n" +
            "        \"language\": \"en\",\n" +
            "        \"previewLink\": \"http://books.google.co.in/books?id=JGH0DwAAQBAJ&printsec=frontcover&dq=android&hl=&cd=3&source=gbs_api\",\n" +
            "        \"infoLink\": \"http://books.google.co.in/books?id=JGH0DwAAQBAJ&dq=android&hl=&source=gbs_api\",\n" +
            "        \"canonicalVolumeLink\": \"https://books.google.com/books/about/Android_For_Dummies.html?hl=&id=JGH0DwAAQBAJ\"\n" +
            "      },\n" +
            "      \"saleInfo\": {\n" +
            "        \"country\": \"IN\",\n" +
            "        \"saleability\": \"NOT_FOR_SALE\",\n" +
            "        \"isEbook\": false\n" +
            "      },\n" +
            "      \"accessInfo\": {\n" +
            "        \"country\": \"IN\",\n" +
            "        \"viewability\": \"PARTIAL\",\n" +
            "        \"embeddable\": true,\n" +
            "        \"publicDomain\": false,\n" +
            "        \"textToSpeechPermission\": \"ALLOWED\",\n" +
            "        \"epub\": {\n" +
            "          \"isAvailable\": false\n" +
            "        },\n" +
            "        \"pdf\": {\n" +
            "          \"isAvailable\": false\n" +
            "        },\n" +
            "        \"webReaderLink\": \"http://play.google.com/books/reader?id=JGH0DwAAQBAJ&hl=&printsec=frontcover&source=gbs_api\",\n" +
            "        \"accessViewStatus\": \"SAMPLE\",\n" +
            "        \"quoteSharingAllowed\": false\n" +
            "      },\n" +
            "      \"searchInfo\": {\n" +
            "        \"textSnippet\": \"Your comprehensive (and very friendly!) reference guide to Android phones and tablets You’re used to hearing it said that the phone in your pocket or tablet by your bed has more computing power than the entire Apollo 11 space program in ...\"\n" +
            "      }\n" +
            "    },\n" +
            "    {\n" +
            "      \"kind\": \"books#volume\",\n" +
            "      \"id\": \"_A5QDwAAQBAJ\",\n" +
            "      \"etag\": \"trOGIskGJQo\",\n" +
            "      \"selfLink\": \"https://www.googleapis.com/books/v1/volumes/_A5QDwAAQBAJ\",\n" +
            "      \"volumeInfo\": {\n" +
            "        \"title\": \"Hello, Android\",\n" +
            "        \"subtitle\": \"Introducing Google's Mobile Development Platform\",\n" +
            "        \"authors\": [\n" +
            "          \"Ed Burnette\"\n" +
            "        ],\n" +
            "        \"publisher\": \"Pragmatic Bookshelf\",\n" +
            "        \"publishedDate\": \"2015-05-04\",\n" +
            "        \"description\": \"Google Android dominates the mobile market, and by targeting Android, your apps can run on most of the phones and tablets in the world. This new fourth edition of the #1 book for learning Android covers all modern Android versions from Android 4.1 through Android 5.0. Freshly added material covers new Android features such as Fragments and Google Play Services. Android is a platform you can't afford not to learn, and this book gets you started. Android is a software toolkit for mobile phones and tablets, created by Google. It's inside more than a billion devices, making Android the number one platform for application developers. Your own app could be running on all those devices! Getting started developing with Android is easy. You don't even need access to an Android phone, just a computer where you can install the Android SDK and the emulator that comes with it. Within minutes, Hello, Android gets you creating your first working application: Android's version of \\\"Hello, World.\\\" From there, you'll build up a more substantial example: an Ultimate Tic-Tac-Toe game. By gradually adding features to the game, you'll learn about many aspects of Android programming, such as creating animated user interfaces, playing music and sound effects, building location-based services (including GPS and cell-tower triangulation), and accessing web services. You'll also learn how to publish your applications to the Google Play Store. This fourth edition of the bestselling Android classic has been revised for Android 4.1-4.3 (Jelly Bean), 4.4 (KitKat), and Android 5.0 (Lollipop). Topics have been streamlined and simplified based on reader feedback, and every page and example has been reviewed and updated for compatibility with the latest versions of Android. If you'd rather be coding than reading about coding, this book is for you.\",\n" +
            "        \"industryIdentifiers\": [\n" +
            "          {\n" +
            "            \"type\": \"ISBN_13\",\n" +
            "            \"identifier\": \"9781680503647\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"type\": \"ISBN_10\",\n" +
            "            \"identifier\": \"1680503642\"\n" +
            "          }\n" +
            "        ],\n" +
            "        \"readingModes\": {\n" +
            "          \"text\": true,\n" +
            "          \"image\": true\n" +
            "        },\n" +
            "        \"pageCount\": 250,\n" +
            "        \"printType\": \"BOOK\",\n" +
            "        \"categories\": [\n" +
            "          \"Computers\"\n" +
            "        ],\n" +
            "        \"maturityRating\": \"NOT_MATURE\",\n" +
            "        \"allowAnonLogging\": true,\n" +
            "        \"contentVersion\": \"1.2.3.0.preview.3\",\n" +
            "        \"panelizationSummary\": {\n" +
            "          \"containsEpubBubbles\": false,\n" +
            "          \"containsImageBubbles\": false\n" +
            "        },\n" +
            "        \"imageLinks\": {\n" +
            "          \"smallThumbnail\": \"http://books.google.com/books/content?id=_A5QDwAAQBAJ&printsec=frontcover&img=1&zoom=5&edge=curl&source=gbs_api\",\n" +
            "          \"thumbnail\": \"http://books.google.com/books/content?id=_A5QDwAAQBAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api\"\n" +
            "        },\n" +
            "        \"language\": \"en\",\n" +
            "        \"previewLink\": \"http://books.google.co.in/books?id=_A5QDwAAQBAJ&pg=PA1&dq=android&hl=&cd=4&source=gbs_api\",\n" +
            "        \"infoLink\": \"https://play.google.com/store/books/details?id=_A5QDwAAQBAJ&source=gbs_api\",\n" +
            "        \"canonicalVolumeLink\": \"https://play.google.com/store/books/details?id=_A5QDwAAQBAJ\"\n" +
            "      },\n" +
            "      \"saleInfo\": {\n" +
            "        \"country\": \"IN\",\n" +
            "        \"saleability\": \"FOR_SALE\",\n" +
            "        \"isEbook\": true,\n" +
            "        \"listPrice\": {\n" +
            "          \"amount\": 2289.2,\n" +
            "          \"currencyCode\": \"INR\"\n" +
            "        },\n" +
            "        \"retailPrice\": {\n" +
            "          \"amount\": 1071.35,\n" +
            "          \"currencyCode\": \"INR\"\n" +
            "        },\n" +
            "        \"buyLink\": \"https://play.google.com/store/books/details?id=_A5QDwAAQBAJ&rdid=book-_A5QDwAAQBAJ&rdot=1&source=gbs_api\",\n" +
            "        \"offers\": [\n" +
            "          {\n" +
            "            \"finskyOfferType\": 1,\n" +
            "            \"listPrice\": {\n" +
            "              \"amountInMicros\": 2289200000,\n" +
            "              \"currencyCode\": \"INR\"\n" +
            "            },\n" +
            "            \"retailPrice\": {\n" +
            "              \"amountInMicros\": 1071350000,\n" +
            "              \"currencyCode\": \"INR\"\n" +
            "            }\n" +
            "          }\n" +
            "        ]\n" +
            "      },\n" +
            "      \"accessInfo\": {\n" +
            "        \"country\": \"IN\",\n" +
            "        \"viewability\": \"PARTIAL\",\n" +
            "        \"embeddable\": true,\n" +
            "        \"publicDomain\": false,\n" +
            "        \"textToSpeechPermission\": \"ALLOWED\",\n" +
            "        \"epub\": {\n" +
            "          \"isAvailable\": true,\n" +
            "          \"acsTokenLink\": \"http://books.google.co.in/books/download/Hello_Android-sample-epub.acsm?id=_A5QDwAAQBAJ&format=epub&output=acs4_fulfillment_token&dl_type=sample&source=gbs_api\"\n" +
            "        },\n" +
            "        \"pdf\": {\n" +
            "          \"isAvailable\": true,\n" +
            "          \"acsTokenLink\": \"http://books.google.co.in/books/download/Hello_Android-sample-pdf.acsm?id=_A5QDwAAQBAJ&format=pdf&output=acs4_fulfillment_token&dl_type=sample&source=gbs_api\"\n" +
            "        },\n" +
            "        \"webReaderLink\": \"http://play.google.com/books/reader?id=_A5QDwAAQBAJ&hl=&printsec=frontcover&source=gbs_api\",\n" +
            "        \"accessViewStatus\": \"SAMPLE\",\n" +
            "        \"quoteSharingAllowed\": false\n" +
            "      },\n" +
            "      \"searchInfo\": {\n" +
            "        \"textSnippet\": \"If you&#39;d rather be coding than reading about coding, this book is for you.\"\n" +
            "      }\n" +
            "    },\n" +
            "    {\n" +
            "      \"kind\": \"books#volume\",\n" +
            "      \"id\": \"nDqkBgAAQBAJ\",\n" +
            "      \"etag\": \"joAXDk3xrxU\",\n" +
            "      \"selfLink\": \"https://www.googleapis.com/books/v1/volumes/nDqkBgAAQBAJ\",\n" +
            "      \"volumeInfo\": {\n" +
            "        \"title\": \"Android App Development For Dummies\",\n" +
            "        \"authors\": [\n" +
            "          \"Michael Burton\"\n" +
            "        ],\n" +
            "        \"publisher\": \"John Wiley & Sons\",\n" +
            "        \"publishedDate\": \"2015-03-09\",\n" +
            "        \"description\": \"The updated edition of the bestselling guide to Android app development If you have ambitions to build an Android app, this hands-on guide gives you everything you need to dig into the development process and turn your great idea into a reality! In this new edition of Android App Development For Dummies, you'll find easy-to-follow access to the latest programming techniques that take advantage of the new features of the Android operating system. Plus, two programs are provided: a simple program to get you started and an intermediate program that uses more advanced aspects of the Android platform. Android mobile devices currently account for nearly 80% of mobile phone market share worldwide, making it the best platform to reach the widest possible audience. With the help of this friendly guide, developers of all stripes will quickly find out how to install the tools they need, design a good user interface, grasp the design differences between phone and tablet applications, handle user input, avoid common pitfalls, and turn a \\\"meh\\\" app into one that garners applause. Create seriously cool apps for the latest Android smartphones and tablets Adapt your existing apps for use on an Android device Start working with programs and tools to create Android apps Publish your apps to the Google Play Store Whether you're a new or veteran programmer, Android App Development For Dummies will have you up and running with the ins and outs of the Android platform in no time.\",\n" +
            "        \"industryIdentifiers\": [\n" +
            "          {\n" +
            "            \"type\": \"ISBN_13\",\n" +
            "            \"identifier\": \"9781119017929\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"type\": \"ISBN_10\",\n" +
            "            \"identifier\": \"1119017920\"\n" +
            "          }\n" +
            "        ],\n" +
            "        \"readingModes\": {\n" +
            "          \"text\": false,\n" +
            "          \"image\": true\n" +
            "        },\n" +
            "        \"pageCount\": 432,\n" +
            "        \"printType\": \"BOOK\",\n" +
            "        \"categories\": [\n" +
            "          \"Computers\"\n" +
            "        ],\n" +
            "        \"maturityRating\": \"NOT_MATURE\",\n" +
            "        \"allowAnonLogging\": false,\n" +
            "        \"contentVersion\": \"1.15.3.0.preview.1\",\n" +
            "        \"panelizationSummary\": {\n" +
            "          \"containsEpubBubbles\": false,\n" +
            "          \"containsImageBubbles\": false\n" +
            "        },\n" +
            "        \"imageLinks\": {\n" +
            "          \"smallThumbnail\": \"http://books.google.com/books/content?id=nDqkBgAAQBAJ&printsec=frontcover&img=1&zoom=5&edge=curl&source=gbs_api\",\n" +
            "          \"thumbnail\": \"http://books.google.com/books/content?id=nDqkBgAAQBAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api\"\n" +
            "        },\n" +
            "        \"language\": \"en\",\n" +
            "        \"previewLink\": \"http://books.google.co.in/books?id=nDqkBgAAQBAJ&printsec=frontcover&dq=android&hl=&cd=5&source=gbs_api\",\n" +
            "        \"infoLink\": \"http://books.google.co.in/books?id=nDqkBgAAQBAJ&dq=android&hl=&source=gbs_api\",\n" +
            "        \"canonicalVolumeLink\": \"https://books.google.com/books/about/Android_App_Development_For_Dummies.html?hl=&id=nDqkBgAAQBAJ\"\n" +
            "      },\n" +
            "      \"saleInfo\": {\n" +
            "        \"country\": \"IN\",\n" +
            "        \"saleability\": \"NOT_FOR_SALE\",\n" +
            "        \"isEbook\": false\n" +
            "      },\n" +
            "      \"accessInfo\": {\n" +
            "        \"country\": \"IN\",\n" +
            "        \"viewability\": \"PARTIAL\",\n" +
            "        \"embeddable\": true,\n" +
            "        \"publicDomain\": false,\n" +
            "        \"textToSpeechPermission\": \"ALLOWED\",\n" +
            "        \"epub\": {\n" +
            "          \"isAvailable\": false\n" +
            "        },\n" +
            "        \"pdf\": {\n" +
            "          \"isAvailable\": false\n" +
            "        },\n" +
            "        \"webReaderLink\": \"http://play.google.com/books/reader?id=nDqkBgAAQBAJ&hl=&printsec=frontcover&source=gbs_api\",\n" +
            "        \"accessViewStatus\": \"SAMPLE\",\n" +
            "        \"quoteSharingAllowed\": false\n" +
            "      },\n" +
            "      \"searchInfo\": {\n" +
            "        \"textSnippet\": \"In this new edition of Android App Development For Dummies, you&#39;ll find easy-to-follow access to the latest programming techniques that take advantage of the new features of the Android operating system.\"\n" +
            "      }\n" +
            "    },\n" +
            "    {\n" +
            "      \"kind\": \"books#volume\",\n" +
            "      \"id\": \"KER0dd2oYP8C\",\n" +
            "      \"etag\": \"M55hi2rmwtk\",\n" +
            "      \"selfLink\": \"https://www.googleapis.com/books/v1/volumes/KER0dd2oYP8C\",\n" +
            "      \"volumeInfo\": {\n" +
            "        \"title\": \"Embedded Android\",\n" +
            "        \"subtitle\": \"Porting, Extending, and Customizing\",\n" +
            "        \"authors\": [\n" +
            "          \"Karim Yaghmour\"\n" +
            "        ],\n" +
            "        \"publisher\": \"\\\"O'Reilly Media, Inc.\\\"\",\n" +
            "        \"publishedDate\": \"2013-03-15\",\n" +
            "        \"description\": \"Embedded Android is for Developers wanting to create embedded systems based on Android and for those wanting to port Android to new hardware, or creating a custom development environment. Hackers and moders will also find this an indispensible guide to how Android works.\",\n" +
            "        \"industryIdentifiers\": [\n" +
            "          {\n" +
            "            \"type\": \"ISBN_13\",\n" +
            "            \"identifier\": \"9781449308292\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"type\": \"ISBN_10\",\n" +
            "            \"identifier\": \"1449308295\"\n" +
            "          }\n" +
            "        ],\n" +
            "        \"readingModes\": {\n" +
            "          \"text\": false,\n" +
            "          \"image\": true\n" +
            "        },\n" +
            "        \"pageCount\": 385,\n" +
            "        \"printType\": \"BOOK\",\n" +
            "        \"categories\": [\n" +
            "          \"Computers\"\n" +
            "        ],\n" +
            "        \"averageRating\": 5,\n" +
            "        \"ratingsCount\": 2,\n" +
            "        \"maturityRating\": \"NOT_MATURE\",\n" +
            "        \"allowAnonLogging\": false,\n" +
            "        \"contentVersion\": \"preview-1.0.0\",\n" +
            "        \"imageLinks\": {\n" +
            "          \"smallThumbnail\": \"http://books.google.com/books/content?id=KER0dd2oYP8C&printsec=frontcover&img=1&zoom=5&edge=curl&source=gbs_api\",\n" +
            "          \"thumbnail\": \"http://books.google.com/books/content?id=KER0dd2oYP8C&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api\"\n" +
            "        },\n" +
            "        \"language\": \"en\",\n" +
            "        \"previewLink\": \"http://books.google.co.in/books?id=KER0dd2oYP8C&printsec=frontcover&dq=android&hl=&cd=6&source=gbs_api\",\n" +
            "        \"infoLink\": \"http://books.google.co.in/books?id=KER0dd2oYP8C&dq=android&hl=&source=gbs_api\",\n" +
            "        \"canonicalVolumeLink\": \"https://books.google.com/books/about/Embedded_Android.html?hl=&id=KER0dd2oYP8C\"\n" +
            "      },\n" +
            "      \"saleInfo\": {\n" +
            "        \"country\": \"IN\",\n" +
            "        \"saleability\": \"NOT_FOR_SALE\",\n" +
            "        \"isEbook\": false\n" +
            "      },\n" +
            "      \"accessInfo\": {\n" +
            "        \"country\": \"IN\",\n" +
            "        \"viewability\": \"PARTIAL\",\n" +
            "        \"embeddable\": true,\n" +
            "        \"publicDomain\": false,\n" +
            "        \"textToSpeechPermission\": \"ALLOWED\",\n" +
            "        \"epub\": {\n" +
            "          \"isAvailable\": false\n" +
            "        },\n" +
            "        \"pdf\": {\n" +
            "          \"isAvailable\": false\n" +
            "        },\n" +
            "        \"webReaderLink\": \"http://play.google.com/books/reader?id=KER0dd2oYP8C&hl=&printsec=frontcover&source=gbs_api\",\n" +
            "        \"accessViewStatus\": \"SAMPLE\",\n" +
            "        \"quoteSharingAllowed\": false\n" +
            "      },\n" +
            "      \"searchInfo\": {\n" +
            "        \"textSnippet\": \"Hackers and moders will also find this an indispensible guide to how Android works.\"\n" +
            "      }\n" +
            "    },\n" +
            "    {\n" +
            "      \"kind\": \"books#volume\",\n" +
            "      \"id\": \"9c2qCgAAQBAJ\",\n" +
            "      \"etag\": \"lfcyUkEloSo\",\n" +
            "      \"selfLink\": \"https://www.googleapis.com/books/v1/volumes/9c2qCgAAQBAJ\",\n" +
            "      \"volumeInfo\": {\n" +
            "        \"title\": \"Android Programming Concepts\",\n" +
            "        \"authors\": [\n" +
            "          \"Trish Cornez\",\n" +
            "          \"Richard Cornez\"\n" +
            "        ],\n" +
            "        \"publisher\": \"Jones & Bartlett Publishers\",\n" +
            "        \"publishedDate\": \"2015-10-01\",\n" +
            "        \"description\": \"Using a hands-on, student-friendly approach, Android Programming Concepts provides a comprehensive foundation for the development of mobile applications for devices and tablets powered by Android. This text explores Android Java and the Android SDK, the implementation of interactivity using touchscreen gesture detection and sensors, and current concepts and techniques for constructing mobile apps that take advantage of the latest Android features. Each chapter features a collection of well-designed and classroom tested labs that provide clear guidance of Android concepts. Each lab is geared toward one or two specific Android concepts, which eliminated distractions and gives the reader better focus on the concepts at hand.\",\n" +
            "        \"industryIdentifiers\": [\n" +
            "          {\n" +
            "            \"type\": \"ISBN_13\",\n" +
            "            \"identifier\": \"9781284070705\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"type\": \"ISBN_10\",\n" +
            "            \"identifier\": \"1284070700\"\n" +
            "          }\n" +
            "        ],\n" +
            "        \"readingModes\": {\n" +
            "          \"text\": false,\n" +
            "          \"image\": true\n" +
            "        },\n" +
            "        \"pageCount\": 834,\n" +
            "        \"printType\": \"BOOK\",\n" +
            "        \"categories\": [\n" +
            "          \"Computers\"\n" +
            "        ],\n" +
            "        \"maturityRating\": \"NOT_MATURE\",\n" +
            "        \"allowAnonLogging\": false,\n" +
            "        \"contentVersion\": \"preview-1.0.0\",\n" +
            "        \"imageLinks\": {\n" +
            "          \"smallThumbnail\": \"http://books.google.com/books/content?id=9c2qCgAAQBAJ&printsec=frontcover&img=1&zoom=5&edge=curl&source=gbs_api\",\n" +
            "          \"thumbnail\": \"http://books.google.com/books/content?id=9c2qCgAAQBAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api\"\n" +
            "        },\n" +
            "        \"language\": \"en\",\n" +
            "        \"previewLink\": \"http://books.google.co.in/books?id=9c2qCgAAQBAJ&printsec=frontcover&dq=android&hl=&cd=7&source=gbs_api\",\n" +
            "        \"infoLink\": \"http://books.google.co.in/books?id=9c2qCgAAQBAJ&dq=android&hl=&source=gbs_api\",\n" +
            "        \"canonicalVolumeLink\": \"https://books.google.com/books/about/Android_Programming_Concepts.html?hl=&id=9c2qCgAAQBAJ\"\n" +
            "      },\n" +
            "      \"saleInfo\": {\n" +
            "        \"country\": \"IN\",\n" +
            "        \"saleability\": \"NOT_FOR_SALE\",\n" +
            "        \"isEbook\": false\n" +
            "      },\n" +
            "      \"accessInfo\": {\n" +
            "        \"country\": \"IN\",\n" +
            "        \"viewability\": \"PARTIAL\",\n" +
            "        \"embeddable\": true,\n" +
            "        \"publicDomain\": false,\n" +
            "        \"textToSpeechPermission\": \"ALLOWED\",\n" +
            "        \"epub\": {\n" +
            "          \"isAvailable\": false\n" +
            "        },\n" +
            "        \"pdf\": {\n" +
            "          \"isAvailable\": false\n" +
            "        },\n" +
            "        \"webReaderLink\": \"http://play.google.com/books/reader?id=9c2qCgAAQBAJ&hl=&printsec=frontcover&source=gbs_api\",\n" +
            "        \"accessViewStatus\": \"SAMPLE\",\n" +
            "        \"quoteSharingAllowed\": false\n" +
            "      },\n" +
            "      \"searchInfo\": {\n" +
            "        \"textSnippet\": \"This text explores Android Java and the Android SDK, the implementation of interactivity using touchscreen gesture detection and sensors, and current concepts and techniques for constructing mobile apps that take advantage of the latest ...\"\n" +
            "      }\n" +
            "    },\n" +
            "    {\n" +
            "      \"kind\": \"books#volume\",\n" +
            "      \"id\": \"-OwtDQAAQBAJ\",\n" +
            "      \"etag\": \"Om9egRtv5HI\",\n" +
            "      \"selfLink\": \"https://www.googleapis.com/books/v1/volumes/-OwtDQAAQBAJ\",\n" +
            "      \"volumeInfo\": {\n" +
            "        \"title\": \"Android Phones For Dummies\",\n" +
            "        \"authors\": [\n" +
            "          \"Dan Gookin\"\n" +
            "        ],\n" +
            "        \"publisher\": \"John Wiley & Sons\",\n" +
            "        \"publishedDate\": \"2016-10-17\",\n" +
            "        \"description\": \"Your full-color guide to putting your Android to work for you Your smartphone is essentially your lifeline—so it's no wonder you chose a simple-to-use, fun-to-customize, and easy-to-operate Android. Cutting through intimidating jargon and covering all the features you need to know about your Android phone, this down-to-earth guide arms you with the knowledge to set up and configure your device, get up and running with texting and emailing, access the Internet, navigate with GPS, synch with a PC, and so much more. Whether you're new to Android phones or have just upgraded to a new model, Android Phones For Dummies makes it fast and easy to make your new smartphone your minion. Written by bestselling author Dan Gookin, it walks you through the basics in a language you can understand before moving on to more advanced topics, like dialing tricks to forward calls, working with predictive text, accessing special characters, manipulating the touch screen, and using a USB connection to synchronize your stuff. Set up your phone and configure its settings Play games, listen to music, and start shooting photos and videos Join the conversation and have fun with social media Make your life easier with Google Voice typing No matter how you slice it, life with an Android phone is more organized and fun—and this book shows you how to make the most of it.\",\n" +
            "        \"industryIdentifiers\": [\n" +
            "          {\n" +
            "            \"type\": \"ISBN_13\",\n" +
            "            \"identifier\": \"9781119310686\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"type\": \"ISBN_10\",\n" +
            "            \"identifier\": \"1119310687\"\n" +
            "          }\n" +
            "        ],\n" +
            "        \"readingModes\": {\n" +
            "          \"text\": false,\n" +
            "          \"image\": true\n" +
            "        },\n" +
            "        \"pageCount\": 352,\n" +
            "        \"printType\": \"BOOK\",\n" +
            "        \"categories\": [\n" +
            "          \"Computers\"\n" +
            "        ],\n" +
            "        \"averageRating\": 3,\n" +
            "        \"ratingsCount\": 1,\n" +
            "        \"maturityRating\": \"NOT_MATURE\",\n" +
            "        \"allowAnonLogging\": false,\n" +
            "        \"contentVersion\": \"0.2.1.0.preview.1\",\n" +
            "        \"panelizationSummary\": {\n" +
            "          \"containsEpubBubbles\": false,\n" +
            "          \"containsImageBubbles\": false\n" +
            "        },\n" +
            "        \"imageLinks\": {\n" +
            "          \"smallThumbnail\": \"http://books.google.com/books/content?id=-OwtDQAAQBAJ&printsec=frontcover&img=1&zoom=5&edge=curl&source=gbs_api\",\n" +
            "          \"thumbnail\": \"http://books.google.com/books/content?id=-OwtDQAAQBAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api\"\n" +
            "        },\n" +
            "        \"language\": \"en\",\n" +
            "        \"previewLink\": \"http://books.google.co.in/books?id=-OwtDQAAQBAJ&printsec=frontcover&dq=android&hl=&cd=8&source=gbs_api\",\n" +
            "        \"infoLink\": \"http://books.google.co.in/books?id=-OwtDQAAQBAJ&dq=android&hl=&source=gbs_api\",\n" +
            "        \"canonicalVolumeLink\": \"https://books.google.com/books/about/Android_Phones_For_Dummies.html?hl=&id=-OwtDQAAQBAJ\"\n" +
            "      },\n" +
            "      \"saleInfo\": {\n" +
            "        \"country\": \"IN\",\n" +
            "        \"saleability\": \"NOT_FOR_SALE\",\n" +
            "        \"isEbook\": false\n" +
            "      },\n" +
            "      \"accessInfo\": {\n" +
            "        \"country\": \"IN\",\n" +
            "        \"viewability\": \"PARTIAL\",\n" +
            "        \"embeddable\": true,\n" +
            "        \"publicDomain\": false,\n" +
            "        \"textToSpeechPermission\": \"ALLOWED\",\n" +
            "        \"epub\": {\n" +
            "          \"isAvailable\": false\n" +
            "        },\n" +
            "        \"pdf\": {\n" +
            "          \"isAvailable\": false\n" +
            "        },\n" +
            "        \"webReaderLink\": \"http://play.google.com/books/reader?id=-OwtDQAAQBAJ&hl=&printsec=frontcover&source=gbs_api\",\n" +
            "        \"accessViewStatus\": \"SAMPLE\",\n" +
            "        \"quoteSharingAllowed\": false\n" +
            "      },\n" +
            "      \"searchInfo\": {\n" +
            "        \"textSnippet\": \"Set up your phone and configure its settings Play games, listen to music, and start shooting photos and videos Join the conversation and have fun with social media Make your life easier with Google Voice typing No matter how you slice it, ...\"\n" +
            "      }\n" +
            "    },\n" +
            "    {\n" +
            "      \"kind\": \"books#volume\",\n" +
            "      \"id\": \"qWYtAAAAQBAJ\",\n" +
            "      \"etag\": \"BqUf1T170ZE\",\n" +
            "      \"selfLink\": \"https://www.googleapis.com/books/v1/volumes/qWYtAAAAQBAJ\",\n" +
            "      \"volumeInfo\": {\n" +
            "        \"title\": \"The Business of Android Apps Development\",\n" +
            "        \"subtitle\": \"Making and Marketing Apps that Succeed on Google Play, Amazon Appstore and More\",\n" +
            "        \"authors\": [\n" +
            "          \"Mark Rollins\",\n" +
            "          \"Roy Sandberg\"\n" +
            "        ],\n" +
            "        \"publisher\": \"Apress\",\n" +
            "        \"publishedDate\": \"2013-07-22\",\n" +
            "        \"description\": \"The growing but still evolving success of the Android platform has ushered in a second mobile technology “gold rush” for app developers. Google Play and Amazon Appstore for Android apps has become the second go-to apps eco for today's app developers. While not yet as large in terms of number of apps as iTunes, Google Play and Amazon Appstore have so many apps that it has become increasingly difficult for new apps to stand out in the crowd. Achieving consumer awareness and sales longevity for your Android app requires a lot of organization and some strategic planning. Written for today's Android apps developer or apps development shop, this new and improved book from Apress, The Business of Android Apps Development, Second Edition, tells you today's story on how to make money on Android apps. This book shows you how to take your app from idea to design to development to distribution and marketing your app on Google Play or Amazon Appstore. This book takes you step-by-step through cost-effective marketing, public relations and sales techniques that have proven successful for professional Android app creators and indie shops—perfect for independent developers on shoestring budgets. It even shows you how to get interest from venture capitalists and how they view a successful app vs. the majority of so-so to unsuccessful apps in Android. No prior business knowledge is required. This is the book you wish you had read before you launched your first app! What you’ll learn How to take your app from idea to design to development to distributing and marketing your app on Google Play or Amazon Appstore How do Venture Capitalists validate new App Ideas, and use their techniques. How to monetize your app: Freemium, ads, in-app purchasing and more What are the programming tips and tricks that help you sell your app How to optimize your app for the marketplace How to marketing your app How to listen to your customer base, and grow your way to greater revenue Who this book is for This book is for those who have an idea for an app, but otherwise may know relatively little about entrepreneurship, app development, or even business in general. You should be able to pick up this book and feel like someone is holding your hand as they go through the process of evaluating your idea, learning to code, placing your app in the marketplace, marketing your app, and finally, improving your app to meet the needs of your customer base. Table of Contents1. The Android Market: A Background 2. Making Sure Your App Will Succeed 3. Legal Issues: Better Safe Than Sorry 4. A Brief Introduction to Android Development 5. Develop Apps Like a Pro 6. Making Money with Ads on Your Application 7. In-App Billing: Putting A Store in Your Application 8. Making App Marketplaces Work for You 9. Getting The Word Out 10. After You Have A User Base\",\n" +
            "        \"industryIdentifiers\": [\n" +
            "          {\n" +
            "            \"type\": \"ISBN_13\",\n" +
            "            \"identifier\": \"9781430250074\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"type\": \"ISBN_10\",\n" +
            "            \"identifier\": \"1430250070\"\n" +
            "          }\n" +
            "        ],\n" +
            "        \"readingModes\": {\n" +
            "          \"text\": true,\n" +
            "          \"image\": true\n" +
            "        },\n" +
            "        \"pageCount\": 168,\n" +
            "        \"printType\": \"BOOK\",\n" +
            "        \"categories\": [\n" +
            "          \"Computers\"\n" +
            "        ],\n" +
            "        \"maturityRating\": \"NOT_MATURE\",\n" +
            "        \"allowAnonLogging\": false,\n" +
            "        \"contentVersion\": \"1.1.1.0.preview.3\",\n" +
            "        \"panelizationSummary\": {\n" +
            "          \"containsEpubBubbles\": false,\n" +
            "          \"containsImageBubbles\": false\n" +
            "        },\n" +
            "        \"imageLinks\": {\n" +
            "          \"smallThumbnail\": \"http://books.google.com/books/content?id=qWYtAAAAQBAJ&printsec=frontcover&img=1&zoom=5&edge=curl&source=gbs_api\",\n" +
            "          \"thumbnail\": \"http://books.google.com/books/content?id=qWYtAAAAQBAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api\"\n" +
            "        },\n" +
            "        \"language\": \"en\",\n" +
            "        \"previewLink\": \"http://books.google.co.in/books?id=qWYtAAAAQBAJ&printsec=frontcover&dq=android&hl=&cd=9&source=gbs_api\",\n" +
            "        \"infoLink\": \"http://books.google.co.in/books?id=qWYtAAAAQBAJ&dq=android&hl=&source=gbs_api\",\n" +
            "        \"canonicalVolumeLink\": \"https://books.google.com/books/about/The_Business_of_Android_Apps_Development.html?hl=&id=qWYtAAAAQBAJ\"\n" +
            "      },\n" +
            "      \"saleInfo\": {\n" +
            "        \"country\": \"IN\",\n" +
            "        \"saleability\": \"NOT_FOR_SALE\",\n" +
            "        \"isEbook\": false\n" +
            "      },\n" +
            "      \"accessInfo\": {\n" +
            "        \"country\": \"IN\",\n" +
            "        \"viewability\": \"PARTIAL\",\n" +
            "        \"embeddable\": true,\n" +
            "        \"publicDomain\": false,\n" +
            "        \"textToSpeechPermission\": \"ALLOWED\",\n" +
            "        \"epub\": {\n" +
            "          \"isAvailable\": true,\n" +
            "          \"acsTokenLink\": \"http://books.google.co.in/books/download/The_Business_of_Android_Apps_Development-sample-epub.acsm?id=qWYtAAAAQBAJ&format=epub&output=acs4_fulfillment_token&dl_type=sample&source=gbs_api\"\n" +
            "        },\n" +
            "        \"pdf\": {\n" +
            "          \"isAvailable\": false\n" +
            "        },\n" +
            "        \"webReaderLink\": \"http://play.google.com/books/reader?id=qWYtAAAAQBAJ&hl=&printsec=frontcover&source=gbs_api\",\n" +
            "        \"accessViewStatus\": \"SAMPLE\",\n" +
            "        \"quoteSharingAllowed\": false\n" +
            "      },\n" +
            "      \"searchInfo\": {\n" +
            "        \"textSnippet\": \"This book shows you how to take your app from idea to design to development to distribution and marketing your app on Google Play or Amazon Appstore.\"\n" +
            "      }\n" +
            "    },\n" +
            "    {\n" +
            "      \"kind\": \"books#volume\",\n" +
            "      \"id\": \"M7ngCAAAQBAJ\",\n" +
            "      \"etag\": \"ioqHYl7xW1w\",\n" +
            "      \"selfLink\": \"https://www.googleapis.com/books/v1/volumes/M7ngCAAAQBAJ\",\n" +
            "      \"volumeInfo\": {\n" +
            "        \"title\": \"Teach Yourself VISUALLY Android Phones and Tablets\",\n" +
            "        \"authors\": [\n" +
            "          \"Guy Hart-Davis\"\n" +
            "        ],\n" +
            "        \"publisher\": \"John Wiley & Sons\",\n" +
            "        \"publishedDate\": \"2015-07-07\",\n" +
            "        \"description\": \"Experience all your Android device has to offer! Teach Yourself VISUALLY Android Phones and Tablets, 2nd Edition is the perfect resource if you are a visual learner who wants to master the ins and outs of the Android operating system. With step-by-step instructions driven by targeted, easy-to-understand graphics, this informative book shines a light on the features, functions, and quirks of the Android OS—and shows you how to use them. With the guidance provided by this easy to follow resource, you will quickly access, download, and enjoy books, apps, music, and video content, as well as photos, emails, and other forms of media, right from your phone or tablet! This book is perfect for Android users at beginner to intermediate levels. The Android operating system is graphics intensive, which is why a visual guide is the best way to navigate your Android device. Now that the Android OS is available on both phones and tablets, you can maximize the productivity and convenience of your devices by mastering the features, functions, and quirks of this operating system. Explore the latest Android features and functions Peruse full-color illustrations that walk you, step-by-step, through instructions for using the Android operating system Discover how to access, download, and enjoy multimedia content Sync your Android devices to maximize their capabilities Teach Yourself VISUALLY Android Phones and Tablets, 2nd Edition is the top resource for visual learners wanting to further explore the capabilities of Android devices.\",\n" +
            "        \"industryIdentifiers\": [\n" +
            "          {\n" +
            "            \"type\": \"ISBN_13\",\n" +
            "            \"identifier\": \"9781119116769\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"type\": \"ISBN_10\",\n" +
            "            \"identifier\": \"1119116767\"\n" +
            "          }\n" +
            "        ],\n" +
            "        \"readingModes\": {\n" +
            "          \"text\": false,\n" +
            "          \"image\": true\n" +
            "        },\n" +
            "        \"pageCount\": 320,\n" +
            "        \"printType\": \"BOOK\",\n" +
            "        \"categories\": [\n" +
            "          \"Computers\"\n" +
            "        ],\n" +
            "        \"maturityRating\": \"NOT_MATURE\",\n" +
            "        \"allowAnonLogging\": false,\n" +
            "        \"contentVersion\": \"1.10.2.0.preview.1\",\n" +
            "        \"panelizationSummary\": {\n" +
            "          \"containsEpubBubbles\": false,\n" +
            "          \"containsImageBubbles\": false\n" +
            "        },\n" +
            "        \"imageLinks\": {\n" +
            "          \"smallThumbnail\": \"http://books.google.com/books/content?id=M7ngCAAAQBAJ&printsec=frontcover&img=1&zoom=5&edge=curl&source=gbs_api\",\n" +
            "          \"thumbnail\": \"http://books.google.com/books/content?id=M7ngCAAAQBAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api\"\n" +
            "        },\n" +
            "        \"language\": \"en\",\n" +
            "        \"previewLink\": \"http://books.google.co.in/books?id=M7ngCAAAQBAJ&printsec=frontcover&dq=android&hl=&cd=10&source=gbs_api\",\n" +
            "        \"infoLink\": \"http://books.google.co.in/books?id=M7ngCAAAQBAJ&dq=android&hl=&source=gbs_api\",\n" +
            "        \"canonicalVolumeLink\": \"https://books.google.com/books/about/Teach_Yourself_VISUALLY_Android_Phones_a.html?hl=&id=M7ngCAAAQBAJ\"\n" +
            "      },\n" +
            "      \"saleInfo\": {\n" +
            "        \"country\": \"IN\",\n" +
            "        \"saleability\": \"NOT_FOR_SALE\",\n" +
            "        \"isEbook\": false\n" +
            "      },\n" +
            "      \"accessInfo\": {\n" +
            "        \"country\": \"IN\",\n" +
            "        \"viewability\": \"PARTIAL\",\n" +
            "        \"embeddable\": true,\n" +
            "        \"publicDomain\": false,\n" +
            "        \"textToSpeechPermission\": \"ALLOWED\",\n" +
            "        \"epub\": {\n" +
            "          \"isAvailable\": false\n" +
            "        },\n" +
            "        \"pdf\": {\n" +
            "          \"isAvailable\": false\n" +
            "        },\n" +
            "        \"webReaderLink\": \"http://play.google.com/books/reader?id=M7ngCAAAQBAJ&hl=&printsec=frontcover&source=gbs_api\",\n" +
            "        \"accessViewStatus\": \"SAMPLE\",\n" +
            "        \"quoteSharingAllowed\": false\n" +
            "      },\n" +
            "      \"searchInfo\": {\n" +
            "        \"textSnippet\": \"This book is perfect for Android users at beginner to intermediate levels. The Android operating system is graphics intensive, which is why a visual guide is the best way to navigate your Android device.\"\n" +
            "      }\n" +
            "    }\n" +
            "  ]\n" +
            "}";

    private static final String LOG_TAG = QueryUtils.class.getName();

    private QueryUtils() {

    }

    public static List<Book> extractBooksFromJSONResponse() {
        List<Book> books = new ArrayList<Book>();

        JSONObject root = null;
        try {
            root = new JSONObject(SAMPLE_JSON_RESPONSE);

            JSONArray items = root.getJSONArray("items");

            for (int i = 0; i < items.length(); i++) {
                JSONObject item = items.getJSONObject(i);

                JSONObject volumeInfo = item.getJSONObject("volumeInfo");

                String title = volumeInfo.getString("title");

                JSONArray authors = volumeInfo.getJSONArray("authors");
                String author = authors.getString(0);

                String description = volumeInfo.getString("description");

                JSONObject imageLinks = volumeInfo.getJSONObject("imageLinks");
                String imageUrl = imageLinks.getString("thumbnail").substring(0, 4)
                        + "s" + imageLinks.getString("thumbnail").substring(4);

                String infoLink = volumeInfo.getString("infoLink").substring(0, 4)
                        + "s" + volumeInfo.getString("infoLink").substring(4);

                books.add(new Book(imageUrl, title, author, description, infoLink));
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return books;
    }
}
