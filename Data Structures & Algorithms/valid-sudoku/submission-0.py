class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        
        row = [[] for i in range(9)]
        col = [[] for i in range(9)]
        box = [[] for i in range(9)]

        for i in range(0,9):
            for j in range(0,9):
                if board[i][j]=='.':
                    continue
                
                box_index = (i//3)*3 + j//3
                
                if board[i][j] in row[i] or board[i][j] in col[j] or board[i][j] in box[box_index]:
                    return False
                else:
                    row[i].append(board[i][j])
                    col[j].append(board[i][j])
                    box[box_index].append(board[i][j])
        return True


            
