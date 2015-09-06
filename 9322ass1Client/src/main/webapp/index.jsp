
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>Market Data Service | Web Service Documentation &amp; Demonstration</title>

		<!-- Bootstrap CSS -->
		<link href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet">
		<link href="//cdnjs.cloudflare.com/ajax/libs/animate.css/3.4.0/animate.min.css" rel="stylesheet">
		<link href="//cdnjs.cloudflare.com/ajax/libs/font-awesome/4.4.0/css/font-awesome.min.css" rel="stylesheet">
		
		

		<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
		<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
		<!--[if lt IE 9]>
			<script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
			<script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
		<![endif]-->
		<style>
		body {
			background-color: #f7f7f7;
		}

		.topbar, .service-doc-part-one {
			background-color: #355694;
		}

		.service-doc-part-two {
			background-color: #333333;
		}

		.service-doc-part-three {
			background-color: #e1ba46;
		}

		.topgroup {
			background-color: #e1ba46;
		}

		.topbar, .topgroup {
			padding-top: 15px;
			padding-bottom: 15px;
		}

		.service-doc-part-one, .service-try-part-one, .service-doc-part-two, .service-try-part-two, .service-doc-part-three, .service-doc-part-three {
			padding-top: 60px;
			padding-bottom: 60px;
		}

		.topbar-title, .service-doc-part-one, .service-doc-part-two, .service-doc-part-three {
			color: #fff;
		}

		.topbar-title, .centered-text {
			text-align: center;
		}

		.white-text {
			color: #fff;
		}

		.input-group {
			width: 100%;
		}

		.white-a {
			color: #fff;
		}

		.white-a:hover {
			color: #fff1c5;
		}

		.custom-btn {
			padding: 10px 20px;
			width: 100%;
			text-align: center;
			border: 1px solid #fff;
			border-radius: 5px;
			color: #fff;

			-webkit-transition: .5s;
			-moz-transition: .5s;
			-ms-transition: .5s;
			-o-transition: .5s;
			transition: .5s; /* Transition time when hover */
		}

		.custom-btn:hover {
			background-color: #fff;
			color: #333333;
		}

		.btn-yellow {
			background-color: #e1ba46;
			
		}

		.btn-coffee {
			background-color: #9a7e0a;
		}

		.btn-blue {
			background-color: #355694;
		}
		
		.btn-black {
			background-color: #333333;
		}

		.service-title {
			border-bottom: 1px solid #fff;
		}

		.btn-area {
			margin-top: 15px;
		}

		.page-footer {
			background-color: #333333;
			padding-top: 25px;
			padding-bottom: 25px;
		}

		.back-to-top-hidden {
			display: none;
		}

		.dot-div {
			margin-bottom: 20px;
		}

		.grey-text {
			color: #7c7c7c;
		}

		.grey-text:hover, .white-text:active {
			color: #7c7c7c;
		}

		.grey-text:focus {
			color: #fff;
		}
		</style>
	</head>
	<body class="animated fadeIn">
		<a id="back-to-top" href="#top" class="back-to-top-hidden animated fadeIn">
			<div class="centered-text white-text" style="background-color: #333333; position: fixed; bottom: 20px; right: 20px; width: 50px; height: 50px; padding-top: 8px;">
				<i class="fa fa-arrow-up fa-2x"></i>
			</div>
		</a>

		<div id="right-nav" style="position: fixed; right: 15px;">
			<div class="dot-div">
				<a class="grey-text" id="dot-1" href="#service-1"><i class="fa fa-circle"></i></a>
			</div>
			<div class="dot-div">
				<a class="grey-text" id="dot-2" href="#service-2"><i class="fa fa-circle"></i></a>
			</div>
			<div class="dot-div">
				<a class="grey-text" id="dot-3" href="#service-3"><i class="fa fa-circle"></i></a>
			</div>
		</div>

		<!-- currency service start -->
		<div class="container-fluid" id="top">
			<div class="row topbar">
				<h2 class="topbar-title wow animated fadeIn">COMP9322 SOA Assignment 1 - Documentation and online demos</h2>
			</div>
			<div class="row topgroup">
				<div class="container">
					<div class="row">
						<div class="col-xs-9"><h4 class=" wow animated fadeIn" style="color: #fff;">Presented by group DadImWrong (originally "Dad, I'm wrong T T")</h4></div>
						<div class="col-xs-3"><a id="go-to-product" href="/9322ass1App"><div class="custom-btn btn-black">Go to Service Product</div></a></div>
						
					</div>
				</div>
			</div>
			<div id="service-1" class="row service-doc-part-one">
				<div class="container">
					
					<div class="row">
						<div class="col-xs-7 col-sm-7 col-md-7 col-lg-7 wow animated fadeInLeft">
							<h2 class="centered-text white-text service-title">Request Parameters</h2>
							<div class="row">
								<div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
									<h4 class="centered-text white-text">Parameter Name</h4>
								</div>
								<div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
									<h4 class="centered-text white-text">Description</h4>
								</div>
								<div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
									<h4 class="centered-text white-text">Example</h4>
								</div>
							</div>
							<div class="row">
								<div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
									<p class="centered-text white-text">baseCurrencyCode</p>
								</div>
								<div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
									<p class="centered-text white-text">The currency code which you want to convert FROM.</p>
								</div>
								<div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
									<p class="centered-text white-text">AUD</p>
								</div>
							</div>
							<div class="row">
								<div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
									<p class="centered-text white-text">targetCurrencyCode</p>
								</div>
								<div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
									<p class="centered-text white-text">The currency code which you want to convert TO.</p>
								</div>
								<div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
									<p class="centered-text white-text">CNY</p>
								</div>
							</div>
							<h2 class="centered-text white-text service-title">Response Parameters</h2>
							<div class="row">
								<div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
									<h4 class="centered-text white-text">Parameter Name</h4>
								</div>
								<div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
									<h4 class="centered-text white-text">Description</h4>
								</div>
								<div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
									<h4 class="centered-text white-text">Example</h4>
								</div>
							</div>
							<div class="row">
								<div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
									<p class="centered-text white-text">rate</p>
								</div>
								<div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
									<p class="centered-text white-text">The currency rate between baseCurrencyCode and targetCurrencyCode.</p>
								</div>
								<div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
									<p class="centered-text white-text">4.4593</p>
								</div>
							</div>
							<div class="row">
								<div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
									<p class="centered-text white-text">asAt</p>
								</div>
								<div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
									<p class="centered-text white-text">The date of this rate in dd-MM-yyyy</p>
								</div>
								<div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
									<p class="centered-text white-text">03-09-2015</p>
								</div>
							</div>
							<h2 class="centered-text white-text service-title">Error Messages</h2>
							<div class="row">
								<div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
									<h4 class="centered-text white-text">Error Code</h4>
								</div>
								<div class="col-xs-8 col-sm-3 col-md-8 col-lg-8">
									<h4 class="centered-text white-text">Error Description</h4>
								</div>
							</div>
							<div class="row">
								<div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
									<p class="centered-text white-text">InvalidCurrencyCode</p>
								</div>
								<div class="col-xs-8 col-sm-8 col-md-8 col-lg-8">
									<p class="centered-text white-text">The input currency code is invalid.</p>
								</div>
								<div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
									<p class="centered-text white-text">InvalidServiceCode</p>
								</div>
								<div class="col-xs-8 col-sm-8 col-md-8 col-lg-8">
									<p class="centered-text white-text">The service code given to Yahoo Financial Web service is invalid.</p>
								</div>
							
								<div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
									<p class="centered-text white-text">ProgramError</p>
								</div>
								<div class="col-xs-8 col-sm-8 col-md-8 col-lg-8">
									<p class="centered-text white-text">Web service program internal error.</p>
								</div>
							</div>
						</div>
						<div class="col-xs-1 col-sm-1 col-md-1 col-lg-1">
							
						</div>
						<div class="col-xs-4 col-sm-4 col-md-4 col-lg-4 wow animated fadeInRight" style="padding-top: 60px;">
							<div class="row">
								<div class="centered-text"><i class="fa fa-usd fa-5x"></i></div>
							</div>
							<h2>Currency Convert Service</h2>
							<p>Currency convert service tells you the currency rate between two type of currencies today. Check us daily and get your right time to exchange and save your money ASAP.</p>
							<p>This SOAP web service is built based on Yahoo Finance Website shown below:</p>
							<p><a class="white-a" href="//finance.yahoo.com/d/quotes.csv?e=.csv&f=sl1d1t1&s=USDAUD=X">http://finance.yahoo.com/d/quotes.csv?e=.csv&f=sl1d1t1&s=USDAUD=X</a></p>
							<div class="row" style="margin-top: 20px;">
								<div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
									<a id="try-currency-link" href="#tryCurrency"><div class="custom-btn btn-yellow">Try It!</div></a>
								</div>
								<div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
									<a href="/9322ass1/currencyConvertService?wsdl"><div class="custom-btn">See WSDL</div></a>
								</div>
							</div>	
						</div>
					</div>
				</div>
				
			</div>
		</div>

		<div id="tryCurrency" class="container service-try-part-one">
			<div class="row">
				<div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
					
				</div>
	        	<div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
	        		<form action="yahooExchangeRate" method="POST" role="form">
		        		<legend class="centered-text">Test CurrencyConvertService</legend>
		        	
		        		<div class="input-group wow animated fadeInLeftBig">
		        			<label class="centered-text" for="">Base currency code (e.g. CNY)</label>
		        			<input name="baseCurrencyCode" type="text" class="form-control" id="" placeholder="Currency">
		        		</div>
		        	
		        		<div class="input-group wow animated fadeInRightBig">
		        			<label class="centered-text" for="">Target currency code (e.g. AUD)</label>
		        			<input name="targetCurrencyCode" type="text" class="form-control" id="" placeholder="Currency">
		        		</div>
		        	
		        		<div class="centered-text btn-area wow animated bounceIn"><button type="submit" class="btn btn-primary">Test it!</button></div>
		        	</form>
	        	</div>
	        	<div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
	        		
	        	</div>
			</div>
		</div><!-- currency service end -->

		<!-- import download service start -->
		<div id="service-2" class="container-fluid">
			<div class="row service-doc-part-two">
				<div class="container">
					<div class="row wow animated fadeInDown">
						<h2 class="centered-text">Import Download Service</h2>
						<p class="centered-text">This service includes two parts i.e. importMarketData and downloadFile, which help you import the market data from a given data source URL and get the data file downloaded easily.</p>
						<div class="centered-text"><i class="fa fa-cloud-download fa-5x"></i></div>
					</div>
					<div class="row">
						<div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
							
						</div>
						<div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
							<div class="row" style="margin-top: 20px;">
								<div class="col-xs-6 col-sm-6 col-md-6 col-lg-6 wow animated bounceInUp">
									<a id="try-import-link" href="#tryImportDownload"><div class="custom-btn btn-coffee">Try It!</div></a>
								</div>
								<div class="col-xs-6 col-sm-6 col-md-6 col-lg-6 wow animated bounceInUp">
									<a href="/9322ass1/importDownloadService?wsdl"><div class="custom-btn">See WSDL</div></a>
								</div>
							</div>
						</div>
						<div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
							
						</div>
					</div>
					<div class="row">
						<div class="col-xs-6 col-sm-6 col-md-6 col-lg-6 wow animated fadeIn">
							<h2 class="centered-text white-text">Import Market Data</h2>
							<h3 class="centered-text white-text service-title">Request Parameters</h3>
							<div class="row">
								<div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
									<h5 class="centered-text white-text">Parameter Name</h5>
								</div>
								<div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
									<h5 class="centered-text white-text">Description</h5>
								</div>
								<div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
									<h5 class="centered-text white-text">Example</h5>
								</div>
							</div>
							<div class="row">
								<div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
									<p class="centered-text white-text">sec</p>
								</div>
								<div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
									<p class="centered-text white-text">The security code of the financial instrument (i.e., stock).</p>
								</div>
								<div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
									<p class="centered-text white-text">ABCD</p>
								</div>
							</div>
							<div class="row">
								<div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
									<p class="centered-text white-text">startDate</p>
								</div>
								<div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
									<p class="centered-text white-text">Rows that have a timestamp on or after (i.e., inclusive) this parameter and also satisfy the condition for endDate, are included in the output Market Data file. The format is dd-MM-yyyy.</p>
								</div>
								<div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
									<p class="centered-text white-text">03-09-2015</p>
								</div>
							</div>
							<div class="row">
								<div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
									<p class="centered-text white-text">endDate</p>
								</div>
								<div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
									<p class="centered-text white-text">Rows that have a timestamp on or before (i.e., inclusive) this parameter and also satisfy the condition for startDate, are included in the output Market Data file. The format is dd-MM-yyyy.</p>
								</div>
								<div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
									<p class="centered-text white-text">04-09-2015</p>
								</div>
							</div>
							<div class="row">
								<div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
									<p class="centered-text white-text">dataSourceURL</p>
								</div>
								<div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
									<p class="centered-text white-text">This is a http:// URL that points to the input Market Data file.</p>
								</div>
								<div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
									<p class="centered-text white-text" style="word-wrap: break-word;">https://www.cse.unsw.edu.au/~cs9322/ass/common/files_csv_spec/FinDataSimple.csv</p>
								</div>
							</div>
							<h2 class="centered-text white-text service-title">Response Parameters</h2>
							<div class="row">
								<div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
									<h4 class="centered-text white-text">Parameter Name</h4>
								</div>
								<div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
									<h4 class="centered-text white-text">Description</h4>
								</div>
								<div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
									<h4 class="centered-text white-text">Example</h4>
								</div>
							</div>
							<div class="row">
								<div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
									<p class="centered-text white-text">eventSetId</p>
								</div>
								<div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
									<p class="centered-text white-text">A "handle" or reference that refers to the output Market Data file.</p>
								</div>
								<div class="col-xs-3 col-sm-3 col-md-3 col-lg-3" style="word-wrap: break-word;">
									<p class="centered-text white-text">some_whatever_string</p>
								</div>
							</div>
							<h2 class="centered-text white-text service-title">Error Messages</h2>
							<div class="row">
								<div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
									<h4 class="centered-text white-text">Error Code</h4>
								</div>
								<div class="col-xs-8 col-sm-3 col-md-8 col-lg-8">
									<h4 class="centered-text white-text">Error Description</h4>
								</div>
							</div>
							<div class="row">
								<div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
									<p class="centered-text white-text">InvalidURL</p>
								</div>
								<div class="col-xs-8 col-sm-8 col-md-8 col-lg-8">
									<p class="centered-text white-text">The data source URL given is invalid.</p>
								</div>
								<div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
									<p class="centered-text white-text">InvalidSECCode</p>
								</div>
								<div class="col-xs-8 col-sm-8 col-md-8 col-lg-8">
									<p class="centered-text white-text">The security code of data is invalid.</p>
								</div>
								<div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
									<p class="centered-text white-text">InvalidDates</p>
								</div>
								<div class="col-xs-8 col-sm-8 col-md-8 col-lg-8">
									<p class="centered-text white-text">The startDate/endDate provided has a wrong format instead of dd-MM-yyyy.</p>
								</div>
								<div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
									<p class="centered-text white-text">ProgramError</p>
								</div>
								<div class="col-xs-8 col-sm-8 col-md-8 col-lg-8">
									<p class="centered-text white-text">Web service program internal error.</p>
								</div>
							</div>
						</div>
						<div class="col-xs-6 col-sm-6 col-md-6 col-lg-6 wow animated fadeIn">
							<h2 class="centered-text white-text">Download The File</h2>
							<h3 class="centered-text white-text service-title">Request Parameters</h3>
							<div class="row">
								<div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
									<h5 class="centered-text white-text">Parameter Name</h5>
								</div>
								<div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
									<h5 class="centered-text white-text">Description</h5>
								</div>
								<div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
									<h5 class="centered-text white-text">Example</h5>
								</div>
							</div>
							<div class="row">
								<div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
									<p class="centered-text white-text">eventSetId</p>
								</div>
								<div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
									<p class="centered-text white-text">A "handle" or reference that is the output of the importMarketData operation.</p>
								</div>
								<div class="col-xs-3 col-sm-3 col-md-3 col-lg-3" style="word-wrap: break-word;">
									<p class="centered-text white-text">some_whatever_string</p>
								</div>
							</div>
							<div class="row">
								<div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
									<p class="centered-text white-text">fileType</p>
								</div>
								<div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
									<p class="centered-text white-text">The format of the file.</p>
								</div>
								<div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
									<p class="centered-text white-text">CSV/XML/HTML</p>
								</div>
							</div>
							<h2 class="centered-text white-text service-title">Response Parameters</h2>
							<div class="row">
								<div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
									<p class="centered-text white-text">dataURL</p>
								</div>
								<div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
									<p class="centered-text white-text">This is a http:// URL that points to the Market Data file referenced by the eventSetId input parameter.</p>
								</div>
								<div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
									<p class="centered-text white-text" style="word-wrap: break-word;">http://example.com/somefile.csv</p>
								</div>
							</div>
							<h2 class="centered-text white-text service-title">Error Messages</h2>
							<div class="row">
								<div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
									<h4 class="centered-text white-text">Error Code</h4>
								</div>
								<div class="col-xs-8 col-sm-3 col-md-8 col-lg-8">
									<h4 class="centered-text white-text">Error Description</h4>
								</div>
							</div>
							<div class="row">
								<div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
									<p class="centered-text white-text">InvalidEventSetId</p>
								</div>
								<div class="col-xs-8 col-sm-8 col-md-8 col-lg-8">
									<p class="centered-text white-text">The eventSetId is invalid or not found.</p>
								</div>
								<div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
									<p class="centered-text white-text">InvalidFileType</p>
								</div>
								<div class="col-xs-8 col-sm-8 col-md-8 col-lg-8">
									<p class="centered-text white-text">The file type for download is invalid, which can only be CSV/XML/HTML.</p>
								</div>
								<div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
									<p class="centered-text white-text">ProgramError</p>
								</div>
								<div class="col-xs-8 col-sm-8 col-md-8 col-lg-8">
									<p class="centered-text white-text">Web service program internal error.</p>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div><!-- import download service end -->

		<div id="tryImportDownload" class="container service-try-part-one">
			<div class="row">
	        	<div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
	        		<form action="importMarketData" method="POST" role="form">
		        		<legend class="centered-text">Test importMarketData</legend>
		        	
		        		<div class="input-group wow animated fadeInLeftBig">
		        			<label class="centered-text" for="">Security code</label>
		        			<input name="sec" type="text" class="form-control" id="" placeholder="Security code">
		        		</div>
		        	
		        		<div class="input-group wow animated fadeInRightBig">
		        			<label class="centered-text" for="">Start date of data (dd-MM-yyyy)</label>
		        			<input name="startDate" type="text" class="form-control" id="" placeholder="dd-MM-yyyy">
		        		</div>

		        		<div class="input-group wow animated fadeInLeftBig">
		        			<label class="centered-text" for="">End date of data (dd-MM-yyyy)</label>
		        			<input name="endDate" type="text" class="form-control" id="" placeholder="dd-MM-yyyy">
		        		</div>

		        		<div class="input-group wow animated fadeInRightBig">
		        			<label class="centered-text" for="">Data source URL (http://...)</label>
		        			<input name="dataSourceURL" type="text" class="form-control" id="" value="http://">
		        		</div>
		        	
		        		<div class="centered-text btn-area wow animated bounceIn"><button type="submit" class="btn btn-primary">Test it!</button></div>
		        	</form>
	        	</div>
	        	<div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
	        		<form action="downloadFile" method="POST" role="form">
		        		<legend class="centered-text">Test downloadFile</legend>
		        	
		        		<div class="input-group wow animated fadeInLeftBig">
		        			<label class="centered-text" for="">Event set ID</label>
		        			<input name="eventSetId" type="text" class="form-control" id="" placeholder="ID">
		        		</div>
		        	
		        		<div class="input-group wow animated fadeInRightBig">
		        			<label class="centered-text" for="">File type (CSV/XML/HTML)</label>
		        			<input name="fileType" type="text" class="form-control" id="" placeholder="CSV/XML/HTML">
		        		</div>
		        	
		        		<div class="centered-text btn-area wow animated bounceIn"><button type="submit" class="btn btn-primary">Test it!</button></div>
		        	</form>
	        	</div>
			</div>
		</div>
		
		<div id="service-3" class="container-fluid">
			<div class="row service-doc-part-three">
				<div class="container">
					<div class="row wow animated fadeInUp">
						<h2 class="centered-text">Market Data Util Service</h2>
						<p class="centered-text">Market Data Util Service provides several tools to handle the market data, which includes convert the currency of data and make a summary of data. More tools are on their way to this tool box service.</p>
						<div class="centered-text"><i class="fa fa-archive fa-5x"></i></div>
					</div>
					<div class="row wow animated bounceIn">
						<div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
							
						</div>
						<div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
							<div class="row" style="margin-top: 20px;">
								<div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
									<a id="try-util-link" href="#tryDataUtil"><div class="custom-btn btn-blue">Try It!</div></a>
								</div>
								<div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
									<a href="/9322ass1/marketDataUtilService?wsdl"><div class="custom-btn">See WSDL</div></a>
								</div>
							</div>
						</div>
							
						<div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
							
						</div>
					</div>
				</div>
				<div class="container">
					<div class="row wow animated slideInLeft" style="padding-top: 10px; padding-bottom: 10px;">
						<div class="col-xs-4 col-sm-4 col-md-4 col-lg-4" style="padding-top: 150px;">
							<div class="centered-text"><i class="fa fa-refresh fa-3x"></i></div>
							<h2 class="centered-text">convertMarketData</h2>
							<p>convertMarketData converts the currency of market data into another currency.</p>
						</div>
						<div class="col-xs-1 col-sm-1 col-md-1 col-lg-1">
							
						</div>
						<div class="col-xs-7 col-sm-7 col-md-7 col-lg-7">
							<h2 class="centered-text white-text service-title">Request Parameters</h2>
							<div class="row">
								<div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
									<h4 class="centered-text white-text">Parameter Name</h4>
								</div>
								<div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
									<h4 class="centered-text white-text">Description</h4>
								</div>
								<div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
									<h4 class="centered-text white-text">Example</h4>
								</div>
							</div>
							<div class="row">
								<div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
									<p class="centered-text white-text">eventSetId</p>
								</div>
								<div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
									<p class="centered-text white-text">A "handle" or reference of output market data file.</p>
								</div>
								<div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
									<p class="centered-text white-text" style="word-wrap: break-word;">some-whatever-string</p>
								</div>
							</div>
							<div class="row">
								<div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
									<p class="centered-text white-text">targetCurrency</p>
								</div>
								<div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
									<p class="centered-text white-text">The currency code which you want to convert TO.</p>
								</div>
								<div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
									<p class="centered-text white-text">CNY</p>
								</div>
							</div>

							<h2 class="centered-text white-text service-title">Response Parameters</h2>
							<div class="row">
								<div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
									<p class="centered-text white-text">eventSetId</p>
								</div>
								<div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
									<p class="centered-text white-text">A "handle" or reference of the output of convertMarketData.</p>
								</div>
								<div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
									<p class="centered-text white-text" style="word-wrap: break-word;">some-whatever-string</p>
								</div>
							</div>

							

							<h2 class="centered-text white-text service-title">Error Messages</h2>
							<div class="row">
								<div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
									<h4 class="centered-text white-text">Error Code</h4>
								</div>
								<div class="col-xs-8 col-sm-8 col-md-8 col-lg-8">
									<h4 class="centered-text white-text">Error Description</h4>
								</div>
								<div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
									<p class="centered-text white-text">InvalidEventSetId</p>
								</div>
								<div class="col-xs-8 col-sm-8 col-md-8 col-lg-8">
									<p class="centered-text white-text">The eventSetId is invalid or not found.</p>
								</div>
								<div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
									<p class="centered-text white-text">InvalidCurrencyCode</p>
								</div>
								<div class="col-xs-8 col-sm-8 col-md-8 col-lg-8">
									<p class="centered-text white-text">The input currency code is invalid.</p>
								</div>
								<div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
									<p class="centered-text white-text">InvalidMarketData</p>
								</div>
								<div class="col-xs-8 col-sm-8 col-md-8 col-lg-8">
									<p class="centered-text white-text">The market data is invalid.</p>
								</div>
								<div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
									<p class="centered-text white-text">ProgramError</p>
								</div>
								<div class="col-xs-8 col-sm-8 col-md-8 col-lg-8">
									<p class="centered-text white-text">Web service program internal error.</p>
								</div>
							</div>
						</div>
					</div>

					<div class="row wow animated slideInRight" style="padding-top: 10px; padding-bottom: 10px;">
						<div class="col-xs-7 col-sm-7 col-md-7 col-lg-7">
							<h2 class="centered-text white-text service-title">Request Parameters</h2>
							<div class="row">
								<div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
									<p class="centered-text white-text">Parameter Name</p>
								</div>
								<div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
									<p class="centered-text white-text">Description</p>
								</div>
								<div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
									<p class="centered-text white-text">Example</p>
								</div>
							</div>
							<div class="row">
								<div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
									<p class="centered-text white-text">eventSetId</p>
								</div>
								<div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
									<p class="centered-text white-text">A "handle" or reference of output market data file.</p>
								</div>
								<div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
									<p class="centered-text white-text" style="word-wrap: break-word;">some-whatever-string</p>
								</div>
							</div>

							<h2 class="centered-text white-text service-title">Response Parameters</h2>
							<div class="row">
								<div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
									<p class="centered-text white-text">Parameter Name</p>
								</div>
								<div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
									<p class="centered-text white-text">Description</p>
								</div>
								<div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
									<p class="centered-text white-text">Example</p>
								</div>
							</div>
							<div class="row">
								<div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
									<p class="centered-text white-text">eventSetId</p>
								</div>
								<div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
									<p class="centered-text white-text">The same eventSetID in the input.</p>
								</div>
								<div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
									<p class="centered-text white-text" style="word-wrap: break-word;">some-whatever-string</p>
								</div>
							</div>
							<div class="row">
								<div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
									<p class="centered-text white-text">sec</p>
								</div>
								<div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
									<p class="centered-text white-text">The security code of the financial instrument (i.e., stock).</p>
								</div>
								<div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
									<p class="centered-text white-text">ABCD</p>
								</div>
							</div>
							<div class="row">
								<div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
									<p class="centered-text white-text">startDate</p>
								</div>
								<div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
									<p class="centered-text white-text">The earliest timestamp (i.e., the first line) in the Market Data file associated with the eventSetID.</p>
								</div>
								<div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
									<p class="centered-text white-text">03-09-2015</p>
								</div>
							</div>
							<div class="row">
								<div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
									<p class="centered-text white-text">endDate</p>
								</div>
								<div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
									<p class="centered-text white-text">The latest timestamp (i.e., the last line) in the Market Data file associated with the eventSetID.</p>
								</div>
								<div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
									<p class="centered-text white-text">04-09-2015</p>
								</div>
							</div>
							<div class="row">
								<div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
									<p class="centered-text white-text">currencyCode</p>
								</div>
								<div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
									<p class="centered-text white-text">The currency of the price information in the Market Data file. Return the country currency code prefix associate with the price columns (e.g., USD, EUR, AUD).</p>
								</div>
								<div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
									<p class="centered-text white-text">AUD</p>
								</div>
							</div>
							<div class="row">
								<div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
									<p class="centered-text white-text">numberOfLines</p>
								</div>
								<div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
									<p class="centered-text white-text">The number of lines in the data file (excluding the CSV header line)</p>
								</div>
								<div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
									<p class="centered-text white-text">18562</p>
								</div>
							</div>

							<h2 class="centered-text white-text service-title">Error Messages</h2>
							<div class="row">
								<div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
									<h4 class="centered-text white-text">Error Code</h4>
								</div>
								<div class="col-xs-8 col-sm-8 col-md-8 col-lg-8">
									<h4 class="centered-text white-text">Error Description</h4>
								</div>
								<div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
									<p class="centered-text white-text">InvalidEventSetId</p>
								</div>
								<div class="col-xs-8 col-sm-8 col-md-8 col-lg-8">
									<p class="centered-text white-text">The eventSetId is invalid or not found.</p>
								</div>
								<div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
									<p class="centered-text white-text">InvalidMarketData</p>
								</div>
								<div class="col-xs-8 col-sm-8 col-md-8 col-lg-8">
									<p class="centered-text white-text">The market data is invalid.</p>
								</div>
								<div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
									<p class="centered-text white-text">ProgramError</p>
								</div>
								<div class="col-xs-8 col-sm-8 col-md-8 col-lg-8">
									<p class="centered-text white-text">Web service program internal error.</p>
								</div>
							</div>
						</div>
						<div class="col-xs-1 col-sm-1 col-md-1 col-lg-1">
							
						</div>
						<div class="col-xs-4 col-sm-4 col-md-4 col-lg-4" style="padding-top: 150px;">
							<div class="centered-text"><i class="fa fa-book fa-3x"></i></div>
							<h2 class="centered-text">summaryMarketData</h2>
							<p>summaryMarketData gets a quick summary information about the content of a market data file.</p>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div id="tryDataUtil" class="container service-try-part-one">
			<div class="row">
	        	<div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
	        		<form action="convertMarketData" method="POST" role="form">
		        		<legend class="centered-text">Test convertMarketData</legend>
		        		
		        		<div class="input-group wow animated fadeInLeftBig">
		        			<label class="centered-text" for="">Event set ID</label>
		        			<input name="eventSetId" type="text" class="form-control" id="" placeholder="ID">
		        		</div>
		        		<div class="input-group wow animated fadeInRightBig">
		        			<label class="centered-text" for="">Target currency code (e.g. AUD)</label>
		        			<input name="targetCurrency" type="text" class="form-control" id="" placeholder="Currency">
		        		</div>
		        	
		        		<div class="centered-text btn-area wow animated bounceIn"><button type="submit" class="btn btn-primary">Test it!</button></div>
		        	</form>
	        	</div>
	        	<div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
	        		<form action="summaryMarketData" method="POST" role="form">
		        		<legend class="centered-text">Test summaryMarketData</legend>
		        	
		        		<div class="input-group wow animated fadeInLeftBig">
		        			<label class="centered-text" for="">Event set ID</label>
		        			<input name="eventSetId" type="text" class="form-control" id="" placeholder="ID">
		        		</div>
		        		<div class="centered-text btn-area wow animated bounceIn"><button type="submit" class="btn btn-primary">Test it!</button></div>
		        	</form>
	        	</div>
			</div>
		</div><!-- data util service end -->

		<footer class="page-footer">
			<div class="container-fluid">
				<div class="row">
					<div class="container">
						<div class="row">
							<p class="white-text">Designed and implemented by group DadImWrong, copyright &copy; Qian Weng (BayMax) and Ran Meng (Null) 2015, CSE @UNSW</p>
						</div>
					</div>
				</div>
			</div>
		</footer>

		

		<!-- jQuery -->
		<script src="//code.jquery.com/jquery.js"></script>
		
		<!-- Bootstrap JavaScript -->
		<script src="//netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>

		<script src="//cdnjs.cloudflare.com/ajax/libs/wow/1.1.2/wow.min.js"></script>
		<script>
		/* Initialize wow.js to reveal till scroll */
		new WOW().init();
		</script>
		<script>
		jQuery(document).ready(function() {
			jQuery('#right-nav').css({
				'top': jQuery(window).height() / 2 - 80
			});

			clickToScroll('#try-currency-link', '#tryCurrency', 1000);
			clickToScroll('#try-import-link', '#tryImportDownload', 1000);
			clickToScroll('#try-util-link', '#tryDataUtil', 1000);
			clickToScroll('#back-to-top', '#top', 2000);

			clickToScroll('#dot-1', '#service-1', 1000);
			clickToScroll('#dot-2', '#service-2', 1000);
			clickToScroll('#dot-3', '#service-3', 1000);

			if ($('#back-to-top').length) {
			    var scrollTrigger = 300, // px
			        backToTop = function () {
			            var scrollTop = $(window).scrollTop();
			            if (scrollTop > scrollTrigger) {
			                $('#back-to-top').removeClass('back-to-top-hidden');
			                $('#back-to-top').removeClass('fadeOut');
			                $('#back-to-top').addClass('fadeIn');
			            } else {
			                //$('#back-to-top').addClass('back-to-top-hidden');
			                $('#back-to-top').removeClass('fadeIn');
			                $('#back-to-top').addClass('fadeOut');
			            }
			        };
			    backToTop();
			    $(window).on('scroll', function () {
			        backToTop();
			    });
			}
			
			jQuery('#go-to-product').click(function(e) {
				e.preventDefault();
				newPage = this.href;
				jQuery('body').removeClass('fadeIn');
				jQuery('body').addClass('fadeOut');
				
				setTimeout(goToNewPage, 800);
			});
			
			function goToNewPage() {
				window.location = newPage;
			}
		});

		
			
		function clickToScroll(aLink, aTo, scrollTime) {
			jQuery(aLink).click(function(e) {
				e.preventDefault();
				jQuery('html, body').animate({
					scrollTop: jQuery(aTo).offset().top
				}, scrollTime);
			});
		}
		</script>
	</body>
</html>