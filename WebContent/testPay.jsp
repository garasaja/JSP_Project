<!DOCTYPE html>
<html lang="ko">

<!--  결제 관련 소스 코드 -->
<!-- / 에 회원가입하고
	아래 [1], [2] 부분은 홈페이지(https://www.iamport.kr/getstarted)에 나오는 걸 가져옴
	삼성카드로 결제되는 것 확인 완료!
-->
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    
    <!-- [1] -->
    <script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
    <script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>
</head>

<body>
	<!-- [2] -->
    <script>
        var IMP = window.IMP; // 생략가능
        IMP.init('imp84801963'); // 'iamport' 대신 부여받은 "가맹점 식별코드"를 사용

        IMP.request_pay({
            pg: 'inicis', // version 1.1.0부터 지원.
            pay_method: 'card',
            merchant_uid: 'merchant_' + new Date().getTime(),
            name: '주문명:결제테스트',
            amount: 1000,	// 결제금액. 최소결제금액 제한으로 10원은 허용 안됨. 테스트 결제라 당일 밤 12시쯤에 다시 환불된다고!
            buyer_email: 'ssarmango@gmail.com',
            buyer_name: '홍길동',
            buyer_tel: '010-1234-1234',
            buyer_addr: '서울특별시 강남구 삼성동',
            buyer_postcode: '123-456',
            m_redirect_url: 'https://www.yourdomain.com/payments/complete'
        }, function (rsp) {
            if (rsp.success) {
                var msg = '결제가 완료되었습니다.';
                alert('결제가 완료되었습니다.');
                msg += '고유ID : ' + rsp.imp_uid;
                msg += '상점 거래ID : ' + rsp.merchant_uid;
                msg += '결제 금액 : ' + rsp.paid_amount;
                msg += '카드 승인번호 : ' + rsp.apply_num;
                console.log(msg);	// msg에 표출되는 값들을 db에 저장해둬야 나중에 환불 등의 추후 조치가 가능함
            } else {
                var msg = '결제에 실패하였습니다.';
                msg += '에러내용 : ' + rsp.error_msg;
            }
            alert(msg);
        });
    </script>

</body>

</html>