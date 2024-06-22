def solution(id_list, report, k):
    answer = [0]*len(id_list)


    # [frodo] = set(muzi, apeach)
    reported_from = dict()
    for id in id_list:
        reported_from[id] = set()

    for r in report:
        from_u, to_u = r.split()

        reported_from[to_u].add(from_u)

    for idx, id in enumerate(id_list):
        if len(reported_from[id]) >= k:
            for from_u in reported_from[id]:
                answer[id_list.index(from_u)] += 1


    return answer