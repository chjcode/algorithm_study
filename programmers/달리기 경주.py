def solution(players, callings):
    
    dict = {}
    for idx,player in enumerate(players):
        dict[player] = idx
    
    for player in callings:
        idx = dict[player]
        dict[players[idx]] = idx-1
        dict[players[idx-1]] = idx
        
        players[idx], players[idx-1] = players[idx-1], players[idx]
    
    return players