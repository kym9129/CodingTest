def add_hp(max_hp, current_hp, heal):
    current_hp += heal
    if max_hp < current_hp:
        current_hp = max_hp
    return current_hp



def solution(bandage, health, attacks):

    max_hp = health

    game_time = 1
    bandage_count = 0
    attack_seq = 0
    t, x, y = bandage
    while True:
        attack_time = attacks[attack_seq][0]
        demage = attacks[attack_seq][1]
        
        # 공격 없으면 붕대 감기
        if attack_time != game_time :
            bandage_count += 1
            health = add_hp(max_hp, health, x)
            # t만큼 연속 성공 시 추가 회복
            if bandage_count == t:
                health = add_hp(max_hp, health, y)
                bandage_count = 0
        
        # 공격
        else:
            health -= demage
            bandage_count = 0
            attack_seq += 1

        game_time += 1

        if attack_seq == len(attacks) or health <= 0:
            break

    if health > 0:
        return health
    return -1