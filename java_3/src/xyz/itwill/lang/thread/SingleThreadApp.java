package xyz.itwill.lang.thread;

// 스레드(Thread) : 프로세스의 명령을 실행하기 위한 최소의 작업단위 - 프로그램의 흐름
// 프로세스(Process) : 메모리에 저장된 프로그램 - 중앙처리장치(CPU)에 의해 실행되기 위한 명령

// 단일 스레드 프로그램
// => JVM에 의해 생성된 main 스레드를 이용하여 main() 메소드를 호출하여 명령 실행
// => main() 메소드가 종료되면 main 스레드는 자동 소멸 - 프로그램 종료
public class SingleThreadApp {
	public static void main(String[] args) {

		for (char i = 'A'; i <= 'Z'; i++) {
			System.out.print(i);
		}

		new SingleThread().dispaly();
	}
}