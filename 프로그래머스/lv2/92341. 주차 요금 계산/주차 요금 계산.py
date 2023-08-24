from datetime import datetime, timedelta
import math

def set_car_dict(records):
    
    car_dict = dict()
    for record in records:
        time, car, _type = record.split()
        time = datetime.strptime(time, "%H:%M")
        
        if car not in car_dict:
            car_dict[car] = [time]
        else:
            car_dict[car].insert(0, time)
    
    return car_dict

def solution(fees, records):
    answer = []
    
    # 정렬: 순서. 차량번호, 시간 desc
    
    # 출차시간이 없는지 판단 : 차량별 데이터가 홀수로 있는 경우.
    
    # {차량번호 : [시간, 시간, 시간, 시간]} -> 바로 계산
    # {차량번호 : [시간, 시간, 시간]} -> {차량번호 : [23:59, 시간, 시간, 시간]}
    
    car_dict = set_car_dict(records)
    
    
    # 주차시간 = out시간 - in시간
    # 주차시간이 없는 경우 23:59 - in시간
    
    price_map = dict()
    for car, times in car_dict.items():
        if len(times) % 2 != 0:
            default_time = datetime.strptime("23:59", "%H:%M")
            times.insert(0, default_time)
        
        # 주차 시간 계산
        parking_time = 0
        for i in range(0, len(times), 2):
            # print(f'{times[i]} - {times[i+1]} = {times[i] - times[i+1]}')
            time_diff =  (times[i] - times[i+1])
            parking_time += time_diff.total_seconds() / 60
            
        parking_minute = int(parking_time)
        
        # 요금 계산
        DEFAULT_TIME = fees[0]
        DEFAULT_FEE = fees[1]
        OVER_TIME = fees[2]
        OVER_FEE = fees[3]
        price = 0
        if parking_minute <= DEFAULT_TIME:
            price = DEFAULT_FEE
        else:
            price = DEFAULT_FEE + math.ceil((parking_minute - DEFAULT_TIME) / OVER_TIME) * OVER_FEE
        
        
        price_map[car] = price
    
    # 차량번호 sort
    # print(price_map)
    for key in sorted(price_map.keys()):
        answer.append(price_map[key])
    
    
    
    return answer