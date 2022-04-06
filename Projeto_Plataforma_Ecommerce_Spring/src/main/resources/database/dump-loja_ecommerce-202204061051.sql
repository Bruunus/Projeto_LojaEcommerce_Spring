-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: localhost    Database: loja_ecommerce
-- ------------------------------------------------------
-- Server version	8.0.27

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `authorities`
--

DROP TABLE IF EXISTS `authorities`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `authorities` (
  `username` varchar(200) NOT NULL,
  `authority` varchar(100) NOT NULL,
  UNIQUE KEY `ix_auth_username` (`username`,`authority`),
  CONSTRAINT `fk_authorities_users` FOREIGN KEY (`username`) REFERENCES `users` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `authorities`
--

LOCK TABLES `authorities` WRITE;
/*!40000 ALTER TABLE `authorities` DISABLE KEYS */;
INSERT INTO `authorities` VALUES ('brunus','ROLE_ADM'),('paola','ROLE_ADM');
/*!40000 ALTER TABLE `authorities` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pedido`
--

DROP TABLE IF EXISTS `pedido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pedido` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `data_da_entrega` date DEFAULT NULL,
  `descricao` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `nome_produto` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `url_imagem` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `url_produto` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `valor_negociado` decimal(19,2) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `user_username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKjgvb1pj32pv4ub09dofgm2eoh` (`user_username`)
) ENGINE=MyISAM AUTO_INCREMENT=37 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pedido`
--

LOCK TABLES `pedido` WRITE;
/*!40000 ALTER TABLE `pedido` DISABLE KEYS */;
INSERT INTO `pedido` VALUES (1,'2022-04-04','Xiaomi é top !!! Vamos comprar !!!','Xiaomi Redmi 9','https://images-americanas.b2w.io/produtos/3386060401/imagens/xiaomi-redmi-9-dual-sim-64-gb-sky-blue-4-gb-ram/3386060401_1_large.jpg','https://www.americanas.com.br/produto/3386060401?pfm_carac=xiaomi-redmi-note-9-128gb-4gb-ram&pfm_page=search&pfm_pos=grid&pfm_type=search_page&offerId=60c114a052131c3c81216fcc',NULL,'AGUARDANDO','brunus'),(16,'2022-03-25','Imprime cupom fiscal top','Impressora Fiscal Térmica ','https://http2.mlstatic.com/D_NQ_NP_939994-MLB49117270735_022022-O.webp','http://helooImpressoratermica.net',650.00,'APROVADO','paola'),(18,'2022-04-10','Notebook branco com teclas pretas','Notebook Samsung Book Led 15\'\' Ci3-1115g4 4gb 1tb Fhd W10','https://http2.mlstatic.com/D_NQ_NP_641950-MLA45451271099_042021-O.webp','https://produto.mercadolivre.com.br/MLB-1845799258-notebook-samsung-book-led-15-ci3-1115g4-4gb-1tb-fhd-w10-_JM?matt_tool=91909701&matt_word=&matt_source=google&matt_campaign_id=14303413598&matt_ad_group_id=129016979490&matt_match_type=&matt_network=g&matt_device=c&matt_creative=584295662765&matt_keyword=&matt_ad_position=&matt_ad_type=pla&matt_merchant_id=156066097&matt_product_id=MLB1845799258&matt_product_partition_id=1635172850761&matt_target_id=aud-1457490207548:pla-1635172850761&gclid=Cj0KCQjw29CRBhCUARIsAOboZbI3zzmixR_bPH8Qj7SoL4KmtyoTd9bPe97r4VjJ0dsRdZgYS3m5MigaAibLEALw_wcB',2400.00,'ENTREGUE','paola'),(17,'2022-03-26','HD de 2TB sata ótimo desempenho, aproveite !!!\r\n','HD Interno Western Digital Red 2TB NAS RED SATA 64MB 3.5 5400 RPM (WD20EFRX-68EUZN0)','https://m.media-amazon.com/images/I/81J11UrUxHL._AC_SL1500_.jpg','https://www.amazon.com.br/Interno-Western-Digital-SATA-WD20EFRX-68EUZN0/dp/B07V7X1NZ9/ref=asc_df_B07V7X1NZ9/?tag=googleshopp00-20&linkCode=df0&hvadid=379725876717&hvpos=&hvnetw=g&hvrand=9927070915870065752&hvpone=&hvptwo=&hvqmt=&hvdev=c&hvdvcmdl=&hvlocint=&hvlocphy=1001773&hvtargid=pla-820579829698&psc=1',NULL,'AGUARDANDO','brunus'),(23,'2022-03-10','Ótima capa para notebook','Capa Case Estojo Resistente Notebook LG Lenovo Hp Samsung','https://http2.mlstatic.com/D_NQ_NP_973008-MLB44221867521_122020-O.webp','https://magazinepremiumbr.mercadoshops.com.br/MLB-1731862819-capa-case-estojo-resistente-notebook-lg-lenovo-hp-samsung-_JM?utm_source=mercadolivre&utm_medium=cpa&utm_campaign=VIP_PubliShops_Banner_MAGAZINE-PREMIUMBR_659827695#reco_item_pos=2&reco_backend=machinalis-pads&reco_backend_type=low_level&reco_client=vip-pads-right-shops&reco_id=0b62547c-90b3-47eb-8f2a-778a2713ada4&is_advertising=true&ad_domain=VIPDESKTOP_SHOPSRIGHT&ad_position=3&ad_click_id=NWY1MjNiZDItYTNiZi00MDYzLWI1NTUtYjcyYjQwYjk5YTkx',NULL,'AGUARDANDO','brunus'),(24,'2022-02-15','Cadeira gamer top !!!','Cadeira Gamer Profissional TGC12 Preta ThunderX3','https://m.media-amazon.com/images/I/71VqjPlOJAL._AC_SL1500_.jpg','https://www.amazon.com.br/Thunderx3-61900-Cadeira-Preta-Windows/dp/B00ELBQIKA/ref=zg-bs_furniture_4/131-4657138-3474525?pd_rd_w=d87xO&pf_rd_p=c0c0f25f-aaf5-43d0-b46e-c8c2c04a86c2&pf_rd_r=8QJZ924DH9A2AN3HRR13&pd_rd_r=b9c07f19-3460-4c6d-ad59-2e5e1c3e39a2&pd_rd_wg=2ehyG&pd_rd_i=B09K2JRJ6Y&psc=1',NULL,'AGUARDANDO','paola'),(25,'2022-04-05','Interruptor novo zerado o melhor do mercado.','Interruptor Inteligente Smarteck 4X2\" 3 Módulos Bivolt Touch Wi-fi Preto, compatível com Alexa','https://m.media-amazon.com/images/I/617Qz2dR7-L._AC_SL1500_.jpg','https://www.amazon.com.br/Interruptor-Smarteck-M%C3%B3dulos-Touch-Preto/dp/B08DG7S552/ref=sr_1_2_sspa?__mk_pt_BR=%C3%85M%C3%85%C5%BD%C3%95%C3%91&crid=3DA2FURH93NDA&keywords=alexa&qid=1647624070&sprefix=alexa%2Caps%2C295&sr=8-2-spons&ufe=app_do%3Aamzn1.fos.4bddec23-2dcf-4403-8597-e1a02442043d&spLa=ZW5jcnlwdGVkUXVhbGlmaWVyPUFVMkpOTkJNRlZHV0QmZW5jcnlwdGVkSWQ9QTA5NzE4ODQzODdQSDNWTzhSUU9aJmVuY3J5cHRlZEFkSWQ9QTA5NzI0ODUxWTdXSlBIQUszTTU2JndpZGdldE5hbWU9c3BfYXRmJmFjdGlvbj1jbGlja1JlZGlyZWN0JmRvTm90TG9nQ2xpY2s9dHJ1ZQ&th=1',350.00,'ENTREGUE','brunus'),(28,'2022-03-22','PLACA DE SOM VENTION USB PRATA ou PRETA - VAB-S13/VAB-S17-B\r\n\r\nProduto novo! Original! Pronta entrega!\r\n\r\nMarca: Vention\r\nEmbalagem: Sim\r\nTipo: Externo\r\nInterface: USB\r\nCanais: 2\r\nModelo Número: VAB-S13/17\r\nType: USB 2.0 External Sound Card\r\nMaterial: Aluminum Magnesium Alloy\r\nChip: HuaXun C-media\r\nInterface: USB to the microphone and headset two interfaces\r\nPlug: Nickel plating\r\nFeature 1: microphone sound card\r\nFeature 2: audio sound card\r\nFeature 3: Audio card\r\nFeature 4: USB Sound Card','Placa Vention Som Usb','https://http2.mlstatic.com/D_NQ_NP_920796-MLB46684699172_072021-O.webp','https://produto.mercadolivre.com.br/MLB-1943623455-placa-vention-som-usb-usb-x-p2-fone-e-microfone-c-nfe-_JM?variation=90555036152#reco_item_pos=4&reco_backend=machinalis-homes-pdp-boos&reco_backend_type=function&reco_client=home_navigation-recommendations&reco_id=61e91d01-b020-4222-9f11-725d6f8f8aca&c_id=/home/navigation-recommendations/element&c_element_order=5&c_uid=3d91c698-0d17-422a-950a-8fa333430f35',NULL,'ENTREGUE','brunus'),(29,'2022-04-06','Este tablet é ideal para cada uma de suas atividades: editar fotos, documentos, navegar na web e muito mais! Seu design fino, compacto e portátil é a combinação perfeita de desempenho e versatilidade.\r\n\r\nTransferir, sincronizar e acessar aos seus dispositivos quantas vezes quiser agora é possivel. Suas conexões bluetooth, wi-fi, 4g, micro-usb permitem que você maximize suas funções.\r\n\r\nGraças à sua câmera principal de 5 Mpx e frontal de 2 Mpx, você poderá fazer videochamadas ou tirar fotos em qualquer momento e lugar, com excelente qualidade de imagem. Nitidez, brilho e cores vibrantes farão com que suas experiências sejam refletidas de forma ideal.','Tablet Philco','https://http2.mlstatic.com/D_NQ_NP_947113-MLA47931288783_102021-O.webp','https://www.mercadolivre.com.br/tablet-philco-ptb8rsg-8-32gb-cinza-2gb-de-memoria-ram/p/MLB18501687?pdp_filters=category:MLB1648#searchVariation=MLB18501687&position=5&search_layout=grid&type=product&tracking_id=063bd3db-c774-48a7-aa52-ca4e56d34fca',NULL,'ENTREGUE','brunus'),(30,'2021-10-18','O compromisso que define a Philips é fornecer aos seus usuários tecnologias novas e evolucionadas. É por isso que cuida dos detalhes de cada um dos seus produtos para fazer a diferença. Desfrute duma experiência única com este monitor que lhe dá grande qualidade e inovação.\r\n\r\nUm monitor para você\r\nCom a sua tela LED você não só economiza energia, porque seu consumo é baixo, mas você também verá cores nítidas e definidas em seus filmes ou séries favoritas.\r\n','Monitor gamer Philips','https://http2.mlstatic.com/D_NQ_NP_697015-MLA46301099354_062021-O.webp','https://www.mercadolivre.com.br/monitor-gamer-philips-v-272v8a-led-27-preto-100v240v/p/MLB18011160?pdp_filters=category:MLB1648#searchVariation=MLB18011160&position=8&search_layout=grid&type=product&tracking_id=2c290908-ae8d-408c-95f3-0f93fc89b750',NULL,'ENTREGUE','brunus'),(31,'2021-07-22','SUPORTE FONE DE OUVIDO HEARDSET GAMMER PARA MESA E CONTROLE.\r\n\r\nModerno e sofisticado o suporte para fone heardset e controle é perfeito para a organização do ambiente e traz um toque de diferenciação ao seu setup.\r\nO melhor custo benefício da categoria possuí pintura eletroestática resistente a riscos e quedas.\r\nPrivilegie a indústria nacional, estamos aguardando ao seu pedido.','Suporte Fone De Ouvido Heardset E 1 Controle Gammer','https://http2.mlstatic.com/D_NQ_NP_997816-MLB48643318693_122021-O.webp','https://produto.mercadolivre.com.br/MLB-1871533609-suporte-fone-de-ouvido-heardset-e-1-controle-gammer-_JM?searchVariation=83379031642#searchVariation=83379031642&position=31&search_layout=grid&type=item&tracking_id=2c290908-ae8d-408c-95f3-0f93fc89b750',NULL,'ENTREGUE','brunus'),(32,'2021-12-22','A Nvidia é o fabricante líder de placas de vídeo, sua qualidade garante uma experiência positiva no desenvolvimento do motor gráfico do seu computador. Além disso, seus processadores usam tecnologia de ponta para que você possa desfrutar de um produto rápido e durável.','Placa de vídeo Nvidia','https://http2.mlstatic.com/D_NQ_NP_682629-MLA47176797846_082021-O.webp','https://www.mercadolivre.com.br/placa-de-video-nvidia-pcyes-geforce-700-series-gt-740-pa740gt12804d5fz-4gb/p/MLB15798325?pdp_filters=category:MLB1648#searchVariation=MLB15798325&position=15&search_layout=grid&type=product&tracking_id=2c290908-ae8d-408c-95f3-0f93fc89b750',NULL,'ENTREGUE','brunus'),(33,'2021-11-29','Kit montado com:\r\n- Processador Intel Core i7 2600\r\n- Placa Mãe com suporte para até 16Gb de ram e saída de vídeo HDMI\r\n- Cooler padrão 1155\r\n- Memória (2x8gb) 16GB DDR3','Kit Upgrade I7, H61+ Processador I7 + 16gb Oferta Limitada','https://http2.mlstatic.com/D_NQ_NP_917850-MLB49074255625_022022-O.webp','https://produto.mercadolivre.com.br/MLB-1611540653-kit-upgrade-i7-h61-processador-i7-16gb-oferta-limitada-_JM?searchVariation=173772057753#searchVariation=173772057753&position=40&search_layout=grid&type=item&tracking_id=2c290908-ae8d-408c-95f3-0f93fc89b750',NULL,'ENTREGUE','brunus'),(34,'2022-02-04','Mousepad Gamer Evolut Estilo Tapete EG402-BK\r\n\r\n- Modelo: Speed\r\n- Tamanho: 700 x 300 x 2 mm\r\n- Superfície: Malha Poliéster\r\n- Base: Emborrachado\r\n- Borda: Costura de Acabamento','Mousepad Gamer','https://http2.mlstatic.com/D_NQ_NP_737067-MLB48486293892_122021-O.webp','https://produto.mercadolivre.com.br/MLB-1609256426-mousepad-gamer-evolut-grande-eg402-speed-_JM?searchVariation=60814982826#searchVariation=60814982826&position=5&search_layout=grid&type=item&tracking_id=36b39094-e687-4399-b21c-09925e0eac5f',NULL,'ENTREGUE','brunus'),(35,'2022-02-20','A Creality CR-200B é uma impressora 3D com tecnologia FDM ideal para a grande maioria das pessoas. Pois ela já vem montada e é totalmente fechada o que auxilia bastante para aqueles projetos que devem ser impressos com filamentos como o ABS. Uma impressora 3D requintada e de alto desempenho. A impressora CR-200B não só tem as melhores funções, mas também tem um design inteligente e elegante.','Impressora 3D Creality Cr-200b','https://http2.mlstatic.com/D_NQ_NP_766853-MLB48247715050_112021-O.webp','https://produto.mercadolivre.com.br/MLB-2066885334-impressora-creality-cr-200b-1-ano-de-garantia-_JM?searchVariation=173845696977#searchVariation=173845696977&position=24&search_layout=grid&type=item&tracking_id=545c3318-e149-47be-8b74-984a978d1ee8',NULL,'ENTREGUE','brunus'),(36,'2022-03-22','Atravessar fronteiras físicas e alcançar espaços difíceis vai ser possível com o drone LYZRC L900 Pro con bolso. Este produto sofisticado pode ser operado remotamente e intuitivamente. Seus propósitos são amplos e diversos, pois é útil para atividades como jogos, eventos, delivery, logística, fins ecológicos, vigilância, entre outros.','Drone LYZRC L900','https://http2.mlstatic.com/D_NQ_NP_774514-MLA48120594840_112021-O.webp','https://www.mercadolivre.com.br/drone-lyzrc-l900-pro-con-bolso-com-dual-cmera-4k-preto-5ghz-2-baterias/p/MLB18502986?pdp_filters=category:MLB180137#searchVariation=MLB18502986&position=4&search_layout=grid&type=product&tracking_id=71a3d1ab-67e0-4e25-8919-f6e95a332b2d',NULL,'ENTREGUE','brunus');
/*!40000 ALTER TABLE `pedido` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `username` varchar(100) NOT NULL,
  `password` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `enabled` tinyint(1) NOT NULL,
  `enable` bit(1) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES ('brunus','$2a$10$YhBRuMQxp5cGBcscjKIqteg2JtOi/AmF4KC.P9D6uaCJxFExqXT26',1,NULL),('paola','$2a$10$lkisY0PcAiyl2IQmx4gYg.jYA6OWtbBNrmUelWxCvgjUdeJs6F05a',1,NULL);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'loja_ecommerce'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-04-06 10:51:44
