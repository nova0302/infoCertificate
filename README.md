# infoCertificate
## 1. 프로그램 설치

### 1. virtualbox 설치
https://www.virtualbox.org/

### 2. 우분투 리눅스 버츄얼박스 이미지 다운로드 
https://drive.google.com/drive/folders/1COFYDK2_n9Ak4vyYUxfOdlzSZMQWWbFg?usp=sharing

### 3. 버추얼박스에서 우분투 리눅스 이미지 가져오기

## 2. 리눅스에서 간단히 실습해 보기

### 1. c
#### 1. 소스코드
```c
//hello.c
#include <stdio.h>
int main(){
   printf("Hello World\n");
   return 0;;
}
```
#### 2. 컴파일
```shell
>gcc hello.c
```
#### 3. 실행
>./a.out

### 2. java

#### 1. 소스코드
```java
//hello.java
public class Hello{
   public static void main(String[] args){
      System.out.println("Hello World\n");
  }
}
```
#### 2. 실행
```shell
>java hello.java
```

### 3. python
#### 1. 소스코드
```python
//hello.python
print('Hello World')
```

#### 2. 실행
```shell
>python3 hello.py
```
## 3. python thread example
### 1. thread 기초예제
#### 1. thread를 사용하지 않은 예제
```python
import time
start = time.perf_counter()
def do_something():
	print('Sleeping for 1 second...')
	time.sleep(1)
	print('Done Sleeping...')
	
do_something()

finish = time.perf_counter()
print(f'Finished in {round(finish - start, 2)} second(s)')
	
```

#### 2. thread를 사용한 예제
```python
import time
import threading

start = time.perf_counter()
def do_something():
	print('Sleeping for 1 second...')
	time.sleep(1)
	print('Done Sleeping...')

t1 = threading.Thread(target = do_something)	
t2 = threading.Thread(target = do_something)	

t1.start()
t2.start()

t1.join()
t2.join()

finish = time.perf_counter()
print(f'Finished in {round(finish - start, 2)} second(s)')
	
```
### 2. thread 실무예제
#### 1. thread를 사용하지 않은 예제
```python
import requests
import time

img_urls = [
    'https://images.unsplash.com/photo-1516117172878-fd2c41f4a759',
    'https://images.unsplash.com/photo-1532009324734-20a7a5813719',
    'https://images.unsplash.com/photo-1524429656589-6633a470097c',
    'https://images.unsplash.com/photo-1530224264768-7ff8c1789d79',
    'https://images.unsplash.com/photo-1564135624576-c5c88640f235',
    'https://images.unsplash.com/photo-1541698444083-023c97d3f4b6',
    'https://images.unsplash.com/photo-1522364723953-452d3431c267',
    'https://images.unsplash.com/photo-1513938709626-033611b8cc03',
    'https://images.unsplash.com/photo-1507143550189-fed454f93097',
    'https://images.unsplash.com/photo-1493976040374-85c8e12f0c0e',
    'https://images.unsplash.com/photo-1504198453319-5ce911bafcde',
    'https://images.unsplash.com/photo-1530122037265-a5f1f91d3b99',
    'https://images.unsplash.com/photo-1516972810927-80185027ca84',
    'https://images.unsplash.com/photo-1550439062-609e1531270e',
    'https://images.unsplash.com/photo-1549692520-acc6669e2f0c'
]

t1 = time.perf_counter()

for img_url in img_urls:
    img_bytes = requests.get(img_url).content
    img_name = img_url.split('/')[3]
    img_name = f'{img_name}.jpg'
    with open(img_name, 'wb') as img_file:
        img_file.write(img_bytes)
        print(f'{img_name} was downloaded...')
t2 = time.perf_counter()
print(f'Finished in {t2-t1} seconds')
```
#### 2. thread를 사용한 예제
```
import requests
import time
import concurrent.futures

img_urls = [
    'https://images.unsplash.com/photo-1516117172878-fd2c41f4a759',
    'https://images.unsplash.com/photo-1532009324734-20a7a5813719',
    'https://images.unsplash.com/photo-1524429656589-6633a470097c',
    'https://images.unsplash.com/photo-1530224264768-7ff8c1789d79',
    'https://images.unsplash.com/photo-1564135624576-c5c88640f235',
    'https://images.unsplash.com/photo-1541698444083-023c97d3f4b6',
    'https://images.unsplash.com/photo-1522364723953-452d3431c267',
    'https://images.unsplash.com/photo-1513938709626-033611b8cc03',
    'https://images.unsplash.com/photo-1507143550189-fed454f93097',
    'https://images.unsplash.com/photo-1493976040374-85c8e12f0c0e',
    'https://images.unsplash.com/photo-1504198453319-5ce911bafcde',
    'https://images.unsplash.com/photo-1530122037265-a5f1f91d3b99',
    'https://images.unsplash.com/photo-1516972810927-80185027ca84',
    'https://images.unsplash.com/photo-1550439062-609e1531270e',
    'https://images.unsplash.com/photo-1549692520-acc6669e2f0c'
]

t1 = time.perf_counter()

def download_image(img_url):
    img_bytes = requests.get(img_url).content
    img_name = img_url.split('/')[3]
    img_name = f'{img_name}.jpg'
    with open(img_name, 'wb') as img_file:
        img_file.write(img_bytes)
        print(f'{img_name} was downloaded...')

with concurrent.futures.ThreadPoolExecutor() as executor:
    executor.map(download_image, img_urls)


t2 = time.perf_counter()

print(f'Finished in {t2-t1} seconds')
```
