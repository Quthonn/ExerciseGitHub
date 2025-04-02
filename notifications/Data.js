const fs = require('fs');
const dotenv = require('dotenv');

dotenv.config();

const config = JSON.parse(fs.readFileSync('config.json', 'utf8'));

//config.telegram.token = process.env.TELEGRAM_TOKEN;
//config.telegram.chat = process.env.TELEGRAM_CHAT;

String TELEGRAM_TOKEN = System.getenv("TELEGRAM_TOKEN")
String TELEGRAM_CHAT = System.getenv("TELEGRAM_CHAT")

console.log(config);