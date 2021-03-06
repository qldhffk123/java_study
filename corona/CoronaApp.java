package corona;

import java.io.BufferedReader;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.google.gson.Gson;

public class CoronaApp {
	public static CoronaInfo getCoronaInfo(int page) {
		try {
			// 1번 주소 객체 만들기
			URL url = new URL("https://8oi9s0nnth.apigw.ntruss.com/corona19-masks/v1/stores/json?page="+page);
			// 2번 스트림 연결
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			// 3번 버퍼 연결 (문자열)
			BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
			// 4. 문자 더하기
			StringBuilder sb = new StringBuilder();
			String input = "";
			while ((input = br.readLine()) != null) {
				sb.append(input);
			}
			br.close(); // 버퍼 닫기
			con.disconnect(); // 스트림 닫기

			// 5. 자바 오브젝트로 변환
			Gson gson = new Gson();
			CoronaInfo coronaInfo = gson.fromJson(sb.toString(), CoronaInfo.class);
			return coronaInfo;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args) {
		System.out.println("지역을 입력하세요.");
		Scanner sc = new Scanner(System.in);
		String addr = sc.next();

		int page = 1;
		ArrayList<CoronaInfo> coronaInfos = new ArrayList<>();

		for (int i = 0; i < 54; i++) {
			CoronaInfo coronaInfo = getCoronaInfo(page);
			page++;
			coronaInfos.add(coronaInfo);
		}

		coronaInfos.get(0).getStoreInfos().get(0).getAddr();
		for (CoronaInfo coronaInfo : coronaInfos) { 
			List<StoreInfos> storeInfos = coronaInfo.getStoreInfos();

			for (StoreInfos item : storeInfos) { 
				if(item.getAddr().contains(addr)) {
					System.out.println("위치 : "+item.getAddr());
					System.out.println("코드 : "+item.getCode());
					System.out.println("이름 : "+item.getName());
					System.out.println();
				}
			}
		}
	}
}
