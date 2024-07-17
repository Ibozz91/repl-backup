# Stable Voting in Java
This is an algorithm for implementing the "Stable Voting" electoral system, made by Eric Pacuit and Wesley Holiday. Stable Voting is described [here](https://arxiv.org/pdf/2108.00542.pdf) as a better method for single-winner elections.
## Setting Things Up
Put the names of the candidates in `candidates.txt`. Candidate names cannot contain `=`, `:`, or `>`. They are separated by a `;`.<br>
Optionally, put in ballots with a number (number of ballots with this ranking) (if this is not here it is assumed to be one ballot), and then rank candidates with `>` and use `=` for ties. Like this: `89: Candidate 1=c3>Tiger=Kurt Wright=Andy Montroll>Nashville>Leopard>Memphis>Le Pen=East Base=Ralph Nader` <br>
89 implies there are 89 votes with this ranking. The unranked candidates all count as last.