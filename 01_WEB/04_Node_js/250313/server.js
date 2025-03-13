const express = require('express');
const cors = require('cors');

const PORT = 4885;
const server = express();

server.use(cors());

server.get('/request', (req, res) => {
  res.status(200).json('안녀앟세요 여기는 백엔드 개발자입니다.');
});

server.get('/error', (req, res) => {
  res.status(500).json('초비상~~~~.');
});

server.listen(PORT, function () {
  console.log(`서버가 ${PORT}번에서 작동 중입니다.`);
});
