class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        stack = []
        for token in tokens:
            if token == '+':
                stack.append(int(stack.pop() + stack.pop()))
            elif token == '-':
                first_tok,second_tok=stack.pop(),stack.pop()
                stack.append(int(second_tok-first_tok))
            elif token == '*':
                stack.append(int(stack.pop() * stack.pop()))
            elif token == '/':
                first_tok,second_tok=stack.pop(),stack.pop()
                stack.append(int(second_tok/first_tok))
            else:
                stack.append(int(token))
        return stack[0]